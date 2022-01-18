/* stored procedures */
DELIMITER $$
create procedure sp_updateAttempts(
    IN organizationId int,
    OUT response int
    )
    
	BEGIN 
		declare intentos int default 500;
		SELECT pd.AttemptsAvailable 
		INTO intentos
        FROM Pet_Organization_Detail pd, Pet_Organization p 
        WHERE pd.OrganizationId = p.OrganizationId and p.OrganizationId = organizationId;
        if intentos > 0 then
            update Pet_Organization_Detail pd
			INNER JOIN Pet_Organization p ON p.OrganizationId = pd.OrganizationId
            set pd.AttemptsAvailable = intentos-1
            where p.OrganizationId = organizationId;
            set response = 200;
        else
			set response = 401;
		END IF;
	END$$
DELIMITER ;

CALL sp_updateAttempts(1, @response);
select @response

