package com.adopter.app.services.impl;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.adopter.app.models.dto.AdopterDto;
import com.adopter.app.models.dto.AdopterOrganizationDto;
import com.adopter.app.models.dto.PetOrganizationDto;
import com.adopter.app.models.entity.PetOrganization;
import com.adopter.app.models.entity.PetOrganizationDetail;
import com.adopter.app.models.entity.region.District;
import com.adopter.app.models.response.ResponseAdopter;
import com.adopter.app.models.response.ResponseModel;
import com.adopter.app.models.response.ResponsePetOrganization;
import com.adopter.app.models.repository.AdopterRepository;
import com.adopter.app.models.repository.POrganizationCategoryRepository;
import com.adopter.app.models.repository.POrganizationDetailRepository;
import com.adopter.app.models.repository.POrganizationRepository;
import com.adopter.app.models.util.Constants;
import com.adopter.app.services.IPOrganizationService;

@Service
public class POrganizationServiceImpl implements IPOrganizationService {

	private final Logger LOGGER = Logger.getLogger(IPOrganizationService.class.getName());

	@Autowired
	POrganizationRepository organizationRepo;

	@Autowired
	AdopterRepository adopterRepo;

	@Autowired
	POrganizationDetailRepository organizationDetailRepo;

	@Autowired
	POrganizationCategoryRepository organizationCategoryRepo;

	@Override
	public ArrayList<PetOrganizationDto> listAll() {
		try {
			return organizationRepo.listAll();
		} catch (Exception e) {
			LOGGER.log(Level.SEVERE, e.getMessage(), e);
			return null;
		}

	}

	@Override
	public ResponseModel register(PetOrganizationDto petOrganization) {
		try {

			if (organizationRepo.findByName(petOrganization.getNombre()) != null) {
				return new ResponseModel("Organizacion registrada previamente.", HttpStatus.CONFLICT.value());
			} else {

				String actualDate = new SimpleDateFormat("dd/MM/yyyy").format(new Date(0));
				SimpleDateFormat formatter1 = new SimpleDateFormat("dd/MM/yyyy");
				Date date1 = (Date) formatter1.parse(actualDate);

				PetOrganization organization = new PetOrganization();
				organization.setName(petOrganization.getNombre());
				organization.setMembers(petOrganization.getCantidadMiembros());
				organization.setLogo(petOrganization.getLogo());
				organization.setStatus(true);
				organization.setFoundationDate(date1);
				organization.setPetOrganizationCategory(
						organizationCategoryRepo.findCategoryById(petOrganization.getIdOrganizacionCategoria()));

				District distrito = new District();
				distrito.setId(petOrganization.getIdDistrito());
				organization.setDistrict(distrito);

				Integer availableAttempts = 0;

				if (petOrganization.getIdOrganizacionCategoria() == Constants.SMALL_ORGANIZATION) {
					availableAttempts = 10;
				} else if (petOrganization.getIdOrganizacionCategoria() == Constants.MIDDLE_ORGANIZATION) {
					availableAttempts = 15;
				} else if (petOrganization.getIdOrganizacionCategoria() == Constants.LARGE_ORGANIZATION) {
					availableAttempts = 20;
				} else {
					availableAttempts = 5;
				}

				PetOrganizationDetail organizationDetail = new PetOrganizationDetail();
				organizationDetail.setAttemptsAvailable(availableAttempts);
				organizationDetail.setPetOrganization(organization);
				organizationDetailRepo.save(organizationDetail);

				organizationRepo.save(organization);
				return new ResponseModel("Organizacion registrada correctamente.", HttpStatus.CREATED.value());
			}

		} catch (Exception e) {
			LOGGER.log(Level.SEVERE, e.getMessage(), e);
			return new ResponseModel("Ocurrió un error al registrar la organización.",
					HttpStatus.INTERNAL_SERVER_ERROR.value());
		}
	}

	public ResponseAdopter searchAdopter(AdopterOrganizationDto adopterOrganizationDto) {
		try {
			Long idOrganization = adopterOrganizationDto.getIdOrganization();
			if (!validateOrganizationStatus(idOrganization)) {
				return new ResponseAdopter(null, "Organization deshabilitada, contacte con el administrador.",
						HttpStatus.NON_AUTHORITATIVE_INFORMATION.value());

			} else if (organizationRepo.getAttemptsByIdOrganization(idOrganization) < 1) {
				return new ResponseAdopter(null, "Ya no cuenta con búsquedas semanales.", HttpStatus.FORBIDDEN.value());
			} else {
				ArrayList<AdopterDto> adopter = adopterRepo
						.findAdopterByNumberDoc(adopterOrganizationDto.getDocumentNumber());
				organizationRepo.updateAttempts(idOrganization);
				if (adopter.isEmpty()) {
					return new ResponseAdopter(null, "No se encontró adoptante.", HttpStatus.NOT_FOUND.value());
				} else {
					return new ResponseAdopter(adopter, "Adoptante encontrado", HttpStatus.FOUND.value());
				}

			}
		} catch (Exception e) {
			LOGGER.log(Level.SEVERE, e.getMessage(), e);
			return new ResponseAdopter(null, "Ocurrió un error al realizar la búsqueda, intente nuevamente.",
					HttpStatus.INTERNAL_SERVER_ERROR.value());
		}
	}

	@Override
	public ResponsePetOrganization findById(Long idOrganization) {
		try {
			if (!validateOrganizationStatus(idOrganization)) {
				return new ResponsePetOrganization(null, "Organization deshabilitada, contacte con el administrador.",
						HttpStatus.NON_AUTHORITATIVE_INFORMATION.value());

			} else {
				return new ResponsePetOrganization(organizationRepo.findPetOrganizationById(idOrganization),
						"Organizacion encontrada.", HttpStatus.FOUND.value());
			}
		} catch (Exception e) {
			LOGGER.log(Level.SEVERE, e.getMessage(), e);
			return new ResponsePetOrganization(null, "Ocurrió un error al realizar la búsqueda, intente nuevamente.",
					HttpStatus.INTERNAL_SERVER_ERROR.value());
		}
	}

	@Override
	public ResponseAdopter findAdoptersByIdOrganization(Long idOrganization) {
		try {
			if (!validateOrganizationStatus(idOrganization)) {
				return new ResponseAdopter(null, "Organization deshabilitada, contacte con el administrador.",
						HttpStatus.NON_AUTHORITATIVE_INFORMATION.value());
			} else {
				return new ResponseAdopter(adopterRepo.getAdopterByIdOrganization(idOrganization), "Exito",
						HttpStatus.OK.value());
			}
		} catch (Exception e) {
			LOGGER.log(Level.SEVERE, e.getMessage(), e);
			return null;
		}
	}

	public boolean validateOrganizationStatus(Long idOrganization) {
		if (organizationRepo.getStatusByIdOrganization(idOrganization).getStatus()) {
			return true;
		} else {
			return false;
		}

	}

	@Override
	public ResponsePetOrganization edit(PetOrganizationDto petOrganization) {
		try {
			if (!validateOrganizationStatus(petOrganization.getIdOrganization())) {
				return new ResponsePetOrganization(null, "Organization deshabilitada, contacte con el administrador.",
						HttpStatus.NON_AUTHORITATIVE_INFORMATION.value());

			} else {
				Optional<PetOrganization> petOrg = organizationRepo.findById(petOrganization.getIdOrganization());
				if (petOrg.isEmpty()) {
					return new ResponsePetOrganization(
							organizationRepo.findPetOrganizationById(petOrganization.getIdOrganization()),
							"La organización no existe.", HttpStatus.NOT_FOUND.value());
				} else {

					PetOrganization petOrgDb = petOrg.get();
					petOrgDb.setEmail(petOrganization.getEmail());
					petOrgDb.setFacebookLink(petOrganization.getFacebookLink());
					petOrgDb.setInstagramLink(petOrganization.getInstagramLink());
					petOrgDb.setWebsiteLink(petOrganization.getWebsiteLink());
					petOrgDb.setTwitterLink(petOrganization.getTwitterLink());
					System.out.println(petOrganization.getFechaFundacion());
					petOrgDb.setMembers(petOrganization.getCantidadMiembros());
					petOrgDb.setPhone(petOrganization.getPhone());

					organizationRepo.save(petOrgDb);
					return new ResponsePetOrganization(
							organizationRepo.findPetOrganizationById(petOrganization.getIdOrganization()),
							"Editado correctamente.", HttpStatus.OK.value());
				}
			}
		} catch (Exception e) {
			LOGGER.log(Level.SEVERE, e.getMessage(), e);
			return new ResponsePetOrganization(null, "Ocurrió un error al realizar la búsqueda, intente nuevamente.",
					HttpStatus.INTERNAL_SERVER_ERROR.value());
		}
	}

}
