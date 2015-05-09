/* Steven Tardo and Philip Williams
   This script cleans the database,
   then populates the tables required
   for the WorkforceIS database. */

delete from person;
delete from company;
delete from speciality;
delete from job_profile;
delete from knowledge_skill;
delete from course;
delete from job;
delete from project;
delete from job_project;
delete from works;
delete from requires;
delete from person_skill;
delete from course_set;
delete from section;
delete from takes;
insert into person values ('00001', 'Person 1', '123 Anywhere Ave', 'New Orleans', 'LA', '70119', 'person1@uno.edu', 'M', '123-456-7890', '123-456-7890', '123-456-7890');
insert into person values ('00002', 'Person 2', '123 Anywhere Ave', 'New Orleans', 'LA', '70119', 'person2@uno.edu', 'M', '123-456-7890', '123-456-7890', '123-456-7890');
insert into person values ('00003', 'Person 3', '123 Anywhere Ave', 'New Orleans', 'LA', '70119', 'person3@uno.edu', 'M', '123-456-7890', '123-456-7890', '123-456-7890');
insert into person values ('00004', 'Person 4', '123 Anywhere Ave', 'New Orleans', 'LA', '70119', 'person4@uno.edu', 'M', '123-456-7890', '123-456-7890', '123-456-7890');
insert into person values ('00005', 'Person 5', '123 Anywhere Ave', 'New Orleans', 'LA', '70119', 'person5@uno.edu', 'M', '123-456-7890', '123-456-7890', '123-456-7890');
insert into person values ('00006', 'Person 6', '123 Anywhere Ave', 'New Orleans', 'LA', '70119', 'person6@uno.edu', 'M', '123-456-7890', '123-456-7890', '123-456-7890');
insert into person values ('00007', 'Person 7', '123 Anywhere Ave', 'New Orleans', 'LA', '70119', 'person7@uno.edu', 'M', '123-456-7890', '123-456-7890', '123-456-7890');
insert into person values ('00008', 'Person 8', '123 Anywhere Ave', 'New Orleans', 'LA', '70119', 'person8@uno.edu', 'M', '123-456-7890', '123-456-7890', '123-456-7890');
insert into person values ('00009', 'Person 9', '123 Anywhere Ave', 'New Orleans', 'LA', '70119', 'person9@uno.edu', 'M', '123-456-7890', '123-456-7890', '123-456-7890');
insert into person values ('00010', 'Person 10', '123 Anywhere Ave', 'New Orleans', 'LA', '70119', 'person10@uno.edu', 'M', '123-456-7890', '123-456-7890', '123-456-7890');
insert into company values ('00001', '123 Anywhere Ave', 'New Orleans', 'LA', '70119', 'company1.com', 'Company 1');
insert into company values ('00002', '123 Anywhere Ave', 'New Orleans', 'LA', '70119', 'company2.com', 'Company 2');
insert into company values ('00003', '123 Anywhere Ave', 'New Orleans', 'LA', '70119', 'company3.com', 'Company 3');
insert into company values ('00004', '123 Anywhere Ave', 'New Orleans', 'LA', '70119', 'company4.com', 'Company 4');
insert into company values ('00005', '123 Anywhere Ave', 'New Orleans', 'LA', '70119', 'company5.com', 'Company 5');
insert into speciality values ('00001', '00001', 'Speciality 1');
insert into speciality values ('00001', '00002', 'Speciality 2');
insert into speciality values ('00001', '00003', 'Speciality 3');
insert into speciality values ('00001', '00004', 'Speciality 4');
insert into speciality values ('00002', '00001', 'Speciality 1');
insert into speciality values ('00002', '00002', 'Speciality 2');
insert into speciality values ('00002', '00003', 'Speciality 3');
insert into speciality values ('00003', '00001', 'Speciality 1');
insert into speciality values ('00003', '00002', 'Speciality 2');
insert into speciality values ('00004', '00001', 'Speciality 1');
insert into job_profile values ('00001', 'Job 1', 'Job 1');
insert into job_profile values ('00002', 'Job 2', 'Job 2');
insert into job_profile values ('00003', 'Job 3', 'Job 3');
insert into job_profile values ('00004', 'Job 4', 'Job 4');
insert into job_profile values ('00005', 'Job 5', 'Job 5');
insert into job_profile values ('00006', 'Job 6', 'Job 6');
insert into job_profile values ('00007', 'Job 7', 'Job 7');
insert into job_profile values ('00008', 'Job 8', 'Job 8');
insert into knowledge_skill values ('00001', 'Skill 1', 'Skill 1', '1');
insert into knowledge_skill values ('00002', 'Skill 2', 'Skill 2', '2');
insert into knowledge_skill values ('00003', 'Skill 3', 'Skill 3', '3');
insert into knowledge_skill values ('00004', 'Skill 4', 'Skill 4', '4');
insert into knowledge_skill values ('00005', 'Skill 5', 'Skill 5', '5');
insert into knowledge_skill values ('00006', 'Skill 6', 'Skill 6', '6');
insert into knowledge_skill values ('00007', 'Skill 7', 'Skill 7', '7');
insert into knowledge_skill values ('00008', 'Skill 8', 'Skill 8', '8');
insert into knowledge_skill values ('00009', 'Skill 9', 'Skill 9', '9');
insert into knowledge_skill values ('00010', 'Skill 10', 'Skill 10', '10');
insert into course values ('00001', 'Course 1', 'Course 1', '1', 'A', 100.00);
insert into course values ('00002', 'Course 2', 'Course 2', '2', 'A', 200.00);
insert into course values ('00003', 'Course 3', 'Course 3', '3', 'A', 300.00);
insert into course values ('00004', 'Course 4', 'Course 4', '4', 'A', 400.00);
insert into course values ('00005', 'Course 5', 'Course 5', '5', 'A', 400.00);
insert into course values ('00006', 'Course 6', 'Course 6', '6', 'A', 500.00);
insert into course values ('00007', 'Course 7', 'Course 7', '7', 'A', 600.00);
insert into job values ('00001', '00001', 'FT', '100000', 'S', '00001');
insert into job values ('00002', '00002', 'FT', '100000', 'S', '00002');
insert into job values ('00003', '00003', 'FT', '200000', 'S', '00003');
insert into job values ('00004', '00004', 'FT', '300000', 'S', '00004');
insert into job values ('00005', '00001', 'FT', '15', 'W', '00001');
insert into job values ('00006', '00002', 'FT', '20', 'W', '00002');
insert into job values ('00007', '00003', 'FT', '25', 'W', '00003');
insert into job values ('00008', '00004', 'FT', '30', 'W', '00004');
insert into job values ('00009', '00004', 'FT', '30', 'W', '00004');
insert into job values ('00010', '00004', 'FT', '30', 'W', '00004');
insert into job values ('00011', '00005', 'FT', '30', 'W', '00002');
insert into job values ('00012', '00006', 'FT', '30', 'W', '00003');
insert into job values ('00013', '00007', 'FT', '30', 'W', '00002');
insert into job values ('00014', '00007', 'FT', '30', 'W', '00001');
insert into job values ('00015', '00007', 'FT', '30', 'W', '00003');
insert into job values ('00016', '00008', 'FT', '30', 'W', '00001');
insert into project values ('00001', 'Project 1', '00001', '00001', to_date('01-01-2015', 'MM-DD-YYYY'), to_date('06-01-2015', 'MM-DD-YYYY'), '00001');
insert into job_project values ('00001', '00001');
insert into job_project values ('00002', '00001');
insert into job_project values ('00003', '00001');
insert into works values ('00001', '00001');
insert into works values ('00002', '00002');
insert into works values ('00003', '00003');
insert into works values ('00004', '00004');
insert into works values ('00005', '00005');
insert into works values ('00006', '00006');
insert into works values ('00007', '00007');
insert into works values ('00008', '00008');
insert into requires values ('00001', '00001');
insert into requires values ('00001', '00002');
insert into requires values ('00001', '00003');
insert into requires values ('00001', '00004');
insert into requires values ('00002', '00001');
insert into requires values ('00002', '00002');
insert into requires values ('00002', '00003');
insert into requires values ('00002', '00004');
insert into requires values ('00003', '00001');
insert into requires values ('00003', '00002');
insert into requires values ('00003', '00003');
insert into requires values ('00004', '00001');
insert into requires values ('00004', '00002');
insert into requires values ('00005', '00001');
insert into requires values ('00005', '00002');
insert into requires values ('00006', '00001');
insert into requires values ('00006', '00002');
insert into requires values ('00006', '00003');
insert into requires values ('00006', '00004');
insert into requires values ('00006', '00005');
insert into requires values ('00006', '00006');
insert into requires values ('00007', '00001');
insert into requires values ('00007', '00002');
insert into requires values ('00007', '00003');
insert into requires values ('00007', '00004');
insert into requires values ('00007', '00005');
insert into requires values ('00007', '00006');
insert into requires values ('00007', '00007');
insert into requires values ('00008', '00001');
insert into requires values ('00008', '00002');
insert into requires values ('00008', '00003');
insert into requires values ('00008', '00004');
insert into requires values ('00008', '00005');
insert into requires values ('00008', '00006');
insert into requires values ('00008', '00007');
insert into requires values ('00008', '00008');	
insert into person_skill values ('00001', '00001');
insert into person_skill values ('00001', '00002');
insert into person_skill values ('00001', '00003');
insert into person_skill values ('00001', '00004');
insert into person_skill values ('00001', '00005');
insert into person_skill values ('00002', '00001');
insert into person_skill values ('00002', '00002');
insert into person_skill values ('00002', '00003');
insert into person_skill values ('00003', '00001');
insert into person_skill values ('00003', '00002');
insert into person_skill values ('00004', '00001');
insert into person_skill values ('00005', '00001');
insert into person_skill values ('00005', '00002');
insert into person_skill values ('00005', '00003');
insert into person_skill values ('00005', '00004');
insert into person_skill values ('00006', '00001');
insert into person_skill values ('00006', '00002');
insert into person_skill values ('00006', '00003');
insert into person_skill values ('00007', '00001');
insert into person_skill values ('00007', '00002');
insert into person_skill values ('00008', '00001');
insert into person_skill values ('00009', '00001');
insert into person_skill values ('00009', '00002');
insert into person_skill values ('00009', '00003');
insert into person_skill values ('00009', '00004');
insert into person_skill values ('00009', '00005');
insert into course_set values ('00001', '00001');
insert into course_set values ('00001', '00002');
insert into course_set values ('00001', '00004');
insert into course_set values ('00002', '00001');
insert into course_set values ('00002', '00002');
insert into course_set values ('00002', '00003');
insert into course_set values ('00003', '00001');
insert into course_set values ('00003', '00002');
insert into course_set values ('00004', '00001');
insert into course_set values ('00005', '00003');
insert into course_set values ('00005', '00004');
insert into course_set values ('00006', '00002');
insert into course_set values ('00006', '00003');
insert into course_set values ('00006', '00007');
insert into course_set values ('00006', '00008');
insert into course_set values ('00007', '00004');
insert into course_set values ('00007', '00005');
insert into course_set values ('00007', '00006');
insert into course_set values ('00007', '00009');
insert into course_set values ('00007', '00010');
insert into section values ('00001', '001', to_date('06-01-2015', 'MM-DD-YYYY'), 'U', 'CRM', 90);
insert into section values ('00001', '002', to_date('08-01-2015', 'MM-DD-YYYY'), 'U', 'CRM', 110);
insert into section values ('00002', '001', to_date('06-01-2015', 'MM-DD-YYYY'), 'U', 'CRM', 190);
insert into section values ('00002', '002', to_date('08-01-2015', 'MM-DD-YYYY'), 'U', 'CRM', 210);
insert into section values ('00003', '001', to_date('06-01-2015', 'MM-DD-YYYY'), 'U', 'CRM', 290);
insert into section values ('00003', '002', to_date('08-01-2015', 'MM-DD-YYYY'), 'U', 'CRM', 310);
insert into section values ('00004', '001', to_date('06-01-2015', 'MM-DD-YYYY'), 'U', 'CRM', 390);
insert into section values ('00004', '002', to_date('08-01-2015', 'MM-DD-YYYY'), 'U', 'CRM', 410);
insert into section values ('00005', '001', to_date('06-01-2015', 'MM-DD-YYYY'), 'U', 'CRM', 390);
insert into section values ('00005', '002', to_date('08-01-2015', 'MM-DD-YYYY'), 'U', 'CRM', 410);
insert into section values ('00006', '001', to_date('06-01-2015', 'MM-DD-YYYY'), 'U', 'CRM', 490);
insert into section values ('00006', '002', to_date('08-01-2015', 'MM-DD-YYYY'), 'U', 'CRM', 510);
insert into section values ('00007', '001', to_date('06-01-2015', 'MM-DD-YYYY'), 'U', 'CRM', 590);
insert into section values ('00007', '002', to_date('08-01-2015', 'MM-DD-YYYY'), 'U', 'CRM', 610);

drop sequence courseset_seq;
CREATE SEQUENCE CourseSet_seq
START WITH 1
INCREMENT BY 1
MAXVALUE 999999
NOCYCLE;

delete FROM courseset;
INSERT INTO CourseSet(
SELECT CourseSet_seq.NEXTVAL, C1.c_code, C2.c_code, null, 2
FROM Course C1, Course C2
WHERE C1.c_code < C2.c_code);
INSERT INTO CourseSet(
SELECT CourseSet_seq.NEXTVAL, C1.c_code, C2.c_code, C3.c_code, 3
FROM Course C1, Course C2, Course C3
WHERE C1.c_code < C2.c_code AND C2.c_code < C3.c_code);