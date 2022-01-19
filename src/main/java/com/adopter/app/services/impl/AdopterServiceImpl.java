package com.adopter.app.services.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.adopter.app.models.dto.AdopterDetailDto;
import com.adopter.app.models.dto.AdopterDto;
import com.adopter.app.models.entity.Adopter;
import com.adopter.app.models.entity.AdopterDetail;
import com.adopter.app.models.entity.AdopterSeverity;
import com.adopter.app.models.entity.region.District;
import com.adopter.app.models.entity.Document;
import com.adopter.app.models.entity.PetOrganization;
import com.adopter.app.models.response.ResponseAdopter;
import com.adopter.app.models.response.ResponseModel;
import com.adopter.app.models.util.Constants;
import com.adopter.app.services.IAdopterService;
import com.adopter.app.models.repository.AdopterDetailRepository;
import com.adopter.app.models.repository.AdopterRepository;
import com.adopter.app.models.repository.DocumentRepository;
import com.adopter.app.models.repository.POrganizationRepository;

@Service
public class AdopterServiceImpl implements IAdopterService {

	private final Logger LOGGER = Logger.getLogger(IAdopterService.class.getName());

	@Autowired
	AdopterRepository adopterRepo;

	@Autowired
	AdopterDetailRepository adopterDetailRepo;

	@Autowired
	DocumentRepository documentRepo;

	@Autowired
	POrganizationRepository organizationRepo;

	@Override
	public ArrayList<Adopter> listAllEnabled() {
		try {
			ArrayList<Adopter> adopterList = adopterRepo.listEnabledAdopters();
			if (adopterList.size() < 1) {
				System.out.println("-----------No se encontraron adoptantes---------");
				return null;
			} else {
				return adopterList;
			}
		} catch (Exception e) {
			LOGGER.log(Level.SEVERE, e.getMessage(), e);
			return null;
		}

	}

	@Override
	public ResponseModel register(AdopterDto adopterDto) {
		try {
			Boolean existsAdopter = adopterRepo.existsByDocNumber(adopterDto.getDocumentNumber());
			if (existsAdopter) {
				return new ResponseModel("Adoptante registrado previamente.", HttpStatus.CONFLICT.value());
			} else if (adopterDto.getIdOrganization() == null) {
				return new ResponseModel("Se requiere asignar una organizacion.", HttpStatus.CONFLICT.value());
			} else {

				String actualDate = new SimpleDateFormat("dd/MM/yyyy").format(new Date());
				SimpleDateFormat formatter1 = new SimpleDateFormat("dd/MM/yyyy");
				Date date1 = formatter1.parse(actualDate);

				Document document = new Document();
				AdopterSeverity severity = new AdopterSeverity();
				District distrito = new District();
				PetOrganization organization = new PetOrganization();

				Adopter adopter = new Adopter();
				adopter.setFirstName(adopterDto.getFirstName());
				adopter.setLastName(adopterDto.getLastName());
				adopter.setBirthdate(adopterDto.getBirthDate());
				adopter.setCreationDate(date1);
				adopter.setGender(adopterDto.getGender());
				adopter.setPhone(adopterDto.getPhone());
				adopter.setDocNumber(adopterDto.getDocumentNumber());
				adopter.setStatus(Constants.ENABLED);
				
				distrito.setId(adopterDto.getIdDistrito());
				severity.setId(adopterDto.getIdSeverity());
				document.setId(adopterDto.getIdDocument());
				organization.setId(adopterDto.getIdOrganization());

				adopter.setDistrict(distrito);
				adopter.setDocument(document);

				AdopterDetail adopterDetail = new AdopterDetail();
				adopterDetail.setComment(adopterDto.getComments());
				adopterDetail.setEvidence(adopterDto.getEvidence());
				adopterDetail.setIssueDate(adopterDto.getIssueDate());
				adopterDetail.setAdopter(adopter);
				adopterDetail.setAdopterSeverity(severity);
				adopterDetail.setPetOrganization(organization);
				adopterDetail.setAdopter(adopter);

				adopterRepo.save(adopter);
				adopterDetailRepo.save(adopterDetail);

				return new ResponseModel("Adoptante registrado correctamente.", HttpStatus.CREATED.value());

			}
		} catch (Exception e) {
			LOGGER.log(Level.SEVERE, e.getMessage(), e);
			return new ResponseModel("Ocurrió un error al agregar al adoptante.",
					HttpStatus.INTERNAL_SERVER_ERROR.value());
		}

	}

	@Override
	public ResponseModel addComments(AdopterDto adopterDto) {
		try {

			String actualDate = new SimpleDateFormat("dd/MM/yyyy").format(new Date());
			SimpleDateFormat formatter1 = new SimpleDateFormat("dd/MM/yyyy");
			Date date1 = formatter1.parse(actualDate);

			AdopterSeverity severity = new AdopterSeverity();
			PetOrganization organization = new PetOrganization();
			Adopter adopter = new Adopter();

			adopter.setId(adopterDto.getIdAdopter());
			severity.setId(adopterDto.getIdSeverity());
			organization.setId(adopterDto.getIdOrganization());

			AdopterDetail adopterDetail = new AdopterDetail();
			adopterDetail.setComment(adopterDto.getComments());
			adopterDetail.setEvidence(adopterDto.getEvidence());
			adopterDetail.setIssueDate(adopterDto.getIssueDate());
			adopterDetail.setCommentaryCreationDate(date1);
			adopterDetail.setAdopter(adopter);
			adopterDetail.setAdopterSeverity(severity);
			adopterDetail.setPetOrganization(organization);
			adopterDetailRepo.save(adopterDetail);

			return new ResponseModel("Comentario asignado correctamente.", HttpStatus.CREATED.value());

		} catch (Exception e) {
			LOGGER.log(Level.SEVERE, e.getMessage(), e);
			return new ResponseModel("Ocurrió un error al asignar el comentario, intente nuevamente.",
					HttpStatus.INTERNAL_SERVER_ERROR.value());
		}

	}

	@Override
	public ResponseAdopter getByDocumentNumber(String docNumber) {
		try {
			ArrayList<AdopterDto> adopter = adopterRepo.findAdopterByNumberDoc(docNumber);
			if (adopter.size() == 0) {
				return new ResponseAdopter(null, "No se encontró adoptante.", HttpStatus.NOT_FOUND.value());
			} else {
				return new ResponseAdopter(adopter, "Adoptante encontrado.", HttpStatus.FOUND.value());
			}

		} catch (Exception e) {
			LOGGER.log(Level.SEVERE, e.getMessage(), e);
			return new ResponseAdopter(null, "Ocurrió un error al agregar al adoptante.",
					HttpStatus.INTERNAL_SERVER_ERROR.value());
		}
	}

	@Override
	public ArrayList<AdopterDetailDto> getComments(String docNumber) {
		try {
			return adopterRepo.getCommentsByNumberDoc(docNumber);
		} catch (Exception e) {
			LOGGER.log(Level.SEVERE, e.getMessage(), e);
			return null;
		}
	}

	@Override
	public ResponseAdopter getAdopterByIdOrganization(Long idOrganization) {
		try {
			ArrayList<AdopterDto> adopter = new ArrayList<AdopterDto>();
			adopter = adopterRepo.getAdopterByIdOrganization(idOrganization);
			if (adopter.size() < 1) {
				return new ResponseAdopter(null, "No cuenta con adoptantes registrados.", HttpStatus.NOT_FOUND.value());
			} else {
				return new ResponseAdopter(adopter, "Adoptante encontrado", HttpStatus.FOUND.value());
			}

		} catch (Exception e) {
			LOGGER.log(Level.SEVERE, e.getMessage(), e);
			return new ResponseAdopter(null, "Ocurrió un error al agregar al adoptante.",
					HttpStatus.INTERNAL_SERVER_ERROR.value());
		}
	}

	@Override
	public ResponseAdopter logicalDelete(Long idAdopter) {
		try {

			Optional<Adopter> adopter = adopterRepo.findById(idAdopter);
			if (adopter.isEmpty()) {
				return new ResponseAdopter(null, "El adoptante no existe.", HttpStatus.NOT_FOUND.value());
			} else {

				Adopter adopt = adopter.get();
				adopt.setStatus(Constants.DISABLED);
				adopterRepo.save(adopt);
				return new ResponseAdopter(null, "Adoptante deshabilitado", HttpStatus.OK.value());
			}

		} catch (Exception e) {
			LOGGER.log(Level.SEVERE, e.getMessage(), e);
			return new ResponseAdopter(null, "Ocurrió un error al deshabilitar al adoptante.",
					HttpStatus.INTERNAL_SERVER_ERROR.value());
		}
	}

	@Override
	public ResponseAdopter delete(Long idAdopter) {
		try {

			Optional<Adopter> adopter = adopterRepo.findById(idAdopter);
			if (adopter.isEmpty()) {
				return new ResponseAdopter(null, "El adoptante no existe.", HttpStatus.NOT_FOUND.value());
			} else {

				Adopter adopt = adopter.get();
				AdopterDetail adopterDetail = adopterDetailRepo.findByIdAdopter(idAdopter);
				adopterDetailRepo.delete(adopterDetail);

				adopterRepo.delete(adopt);
				return new ResponseAdopter(null, "Adoptante eliminado", HttpStatus.OK.value());
			}

		} catch (Exception e) {
			LOGGER.log(Level.SEVERE, e.getMessage(), e);
			return new ResponseAdopter(null, "Ocurrió un error al deshabilitar al adoptante.",
					HttpStatus.INTERNAL_SERVER_ERROR.value());
		}
	}

}
