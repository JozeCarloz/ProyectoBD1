
-- DROP TABLE

drop table Administrador;
drop table Curso_Requisito;
drop table Matricula;
drop table Curso_Semestre_Grupo;
drop table Curso_Semestre;
drop table Semestre;
drop table Alumno;
drop table Curso;
drop table Profesor;
drop table Usuario;

-- CREATE TABLE

-- -----------------------------------------------------
-- Table `Usuario`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Usuario` (
  `idUsuario` VARCHAR(30) NOT NULL,
  `contrasenia` VARCHAR(30) NOT NULL,
  PRIMARY KEY (`idUsuario`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Profesor`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Profesor` (
  `codProfesor` VARCHAR(8) NOT NULL,
  `nombreProfe` VARCHAR(20) NOT NULL,
  `apellidoPatProfe` VARCHAR(20) NOT NULL,
  `apellidoMatProfe` VARCHAR(20) NOT NULL,
  `idUsuario` VARCHAR(30) NOT NULL,
  PRIMARY KEY (`codProfesor`),
  INDEX `fk_Profesor_Usuario1_idx` (`idUsuario` ASC),
  CONSTRAINT `fk_Profesor_Usuario1`
    FOREIGN KEY (`idUsuario`)
    REFERENCES `Usuario` (`idUsuario`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Semestre`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Semestre` (
  `codSemestre` VARCHAR(6) NOT NULL,
  `descripSem` VARCHAR(45) NULL,
  PRIMARY KEY (`codSemestre`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Curso`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Curso` (
  `codCurso` VARCHAR(4) NOT NULL,
  `nombreCurso` VARCHAR(25) NOT NULL,
  `numCreditos` FLOAT NOT NULL,
  PRIMARY KEY (`codCurso`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Curso_Semestre`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Curso_Semestre` (
  `codCurso` VARCHAR(4) NOT NULL,
  `codSemestre` VARCHAR(6) NOT NULL,
  `codProfesorCoordinador` VARCHAR(8) NULL,
  PRIMARY KEY (`codCurso`, `codSemestre`),
  INDEX `fk_Curso_has_Semestre_Semestre1_idx` (`codSemestre` ASC),
  INDEX `fk_Curso_has_Semestre_Curso_idx` (`codCurso` ASC),
  INDEX `fk_Curso_Semestre_Profesor1_idx` (`codProfesorCoordinador` ASC),
  CONSTRAINT `fk_Curso_has_Semestre_Curso`
    FOREIGN KEY (`codCurso`)
    REFERENCES `Curso` (`codCurso`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Curso_has_Semestre_Semestre1`
    FOREIGN KEY (`codSemestre`)
    REFERENCES `Semestre` (`codSemestre`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Curso_Semestre_Profesor1`
    FOREIGN KEY (`codProfesorCoordinador`)
    REFERENCES `Profesor` (`codProfesor`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Alumno`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Alumno` (
  `codAlumno` VARCHAR(8) NOT NULL,
  `nombreAlum` VARCHAR(25) NOT NULL,
  `apellidoPatAlum` VARCHAR(20) NOT NULL,
  `apellidoMatAlum` VARCHAR(20) NOT NULL,
  `promPonderado` FLOAT NULL,
  `anioIngreso` INT(4) NULL,
  `idUsuario` VARCHAR(30) NOT NULL,
  PRIMARY KEY (`codAlumno`),
  INDEX `fk_Alumno_Usuario1_idx` (`idUsuario` ASC),
  CONSTRAINT `fk_Alumno_Usuario1`
    FOREIGN KEY (`idUsuario`)
    REFERENCES `Usuario` (`idUsuario`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Curso_Semestre_Grupo`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Curso_Semestre_Grupo` (
  `codCurso` VARCHAR(4) NOT NULL,
  `codSemestre` VARCHAR(6) NOT NULL,
  `numGrupo` INT(1) NOT NULL,
  `codProfesor` VARCHAR(8) NULL,
  PRIMARY KEY (`codCurso`, `codSemestre`, `numGrupo`),
  INDEX `fk_Curso_Semestre_has_Grupo_Curso_Semestre1_idx` (`codCurso` ASC, `codSemestre` ASC),
  INDEX `fk_Curso_Semestre_Grupo_Profesor1_idx` (`codProfesor` ASC),
  CONSTRAINT `fk_Curso_Semestre_has_Grupo_Curso_Semestre1`
    FOREIGN KEY (`codCurso` , `codSemestre`)
    REFERENCES `Curso_Semestre` (`codCurso` , `codSemestre`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Curso_Semestre_Grupo_Profesor1`
    FOREIGN KEY (`codProfesor`)
    REFERENCES `Profesor` (`codProfesor`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Matricula`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Matricula` (
  `codAlumno` VARCHAR(8) NOT NULL,
  `codCurso` VARCHAR(4) NOT NULL,
  `codSemestre` VARCHAR(6) NOT NULL,
  `numGrupo` INT(1) NOT NULL,
  `examenParcial` INT(2) NULL,
  `examenFinal` INT(2) NULL,
  `promPractica` INT(2) NULL,
  `notaFinal` INT(2) NULL,
  PRIMARY KEY (`codAlumno`, `codCurso`, `codSemestre`),
  INDEX `fk_Alumno_has_Curso_Semestre_Grupo_Curso_Semestre_Grupo1_idx` (`codCurso` ASC, `codSemestre` ASC, `numGrupo` ASC),
  INDEX `fk_Alumno_has_Curso_Semestre_Grupo_Alumno1_idx` (`codAlumno` ASC),
  CONSTRAINT `fk_Alumno_has_Curso_Semestre_Grupo_Alumno1`
    FOREIGN KEY (`codAlumno`)
    REFERENCES `Alumno` (`codAlumno`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Alumno_has_Curso_Semestre_Grupo_Curso_Semestre_Grupo1`
    FOREIGN KEY (`codCurso` , `codSemestre` , `numGrupo`)
    REFERENCES `Curso_Semestre_Grupo` (`codCurso` , `codSemestre` , `numGrupo`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Curso_Requisito`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Curso_Requisito` (
  `codCursoConRequisitos` VARCHAR(4) NOT NULL,
  `codCursoRequisito` VARCHAR(4) NOT NULL,
  PRIMARY KEY (`codCursoConRequisitos`, `codCursoRequisito`),
  INDEX `fk_Curso_has_Curso_Curso2_idx` (`codCursoRequisito` ASC),
  INDEX `fk_Curso_has_Curso_Curso1_idx` (`codCursoConRequisitos` ASC),
  CONSTRAINT `fk_Curso_has_Curso_Curso1`
    FOREIGN KEY (`codCursoConRequisitos`)
    REFERENCES `Curso` (`codCurso`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Curso_has_Curso_Curso2`
    FOREIGN KEY (`codCursoRequisito`)
    REFERENCES `Curso` (`codCurso`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Administrador`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Administrador` (
  `codAdministrador` VARCHAR(8) NOT NULL,
  `nombreAdmin` VARCHAR(25) NULL,
  `apellidoPatAdmin` VARCHAR(20) NULL,
  `apellidoMatAdmin` VARCHAR(20) NULL,
  `idUsuario` VARCHAR(30) NOT NULL,
  PRIMARY KEY (`codAdministrador`),
  INDEX `fk_Administrador_Usuario1_idx` (`idUsuario` ASC),
  CONSTRAINT `fk_Administrador_Usuario1`
    FOREIGN KEY (`idUsuario`)
    REFERENCES `Usuario` (`idUsuario`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;