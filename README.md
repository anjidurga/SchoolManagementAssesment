

**1. Softwares and their versions used for development and deployement of the project**
   1. Liferay Community Edition Portal 7.1.0 CE GA1 (Judson / Build 7100 / July 2, 2018)
   1. Mysql- 5.7.20
   1. Liferay workspace with Gradle build tool. 	
		
**1. Configure Liferay workspace in Editor**  
   1. Clone the Liferay workspace from the git location (lrworkpace)
   1. Import the LW into LDS or any editor.
   1. Change the server path in gradle.properties.
   1. Run the deploy task.
	
1. **Deploy components**	
   1. Downlod the jar from folder "Step_1-jars", then copy the jars into Liferay deploy folder
   1. Downlod the jar from folder "Step_2-jars", then copy the jar into Liferay deploy folder.
	
**1. Liferay admininstration setup.**  
   1. Login to liferay with admin user.
   1. Verify whether site-template,role and site(School Management) has been created from the upgrade process.
   1. For that, Go-to Site --> Site Templates . Check School Management Site template exist.
   1. Go-to Roles --> Regular role. Check whether role "school_mng_admin" created. If yes, select the "school_mng_admin" and check the "define permission" for that role.
	   This role should have access to "school-web-portlet".
	   
   1. Go-to Sites --> Sites --> Verify whether "School Management" Site created.
	
   1. Acess the url http://localhost:8089/web/school-management/school-portlet  (To initiate all permission control : Note: "This page is not required, it is just for one time activity")
    1. Access the url http://localhost:8089/web/school-management/school-data
	
    1. Create a user and assign to role "schoolmng_admin".	
   1. Perform CRUD operation in "School Data" page.
	
     
**1. Functionality**
    1. Logged in user can view the school data and can search the data.
	1. User who has rights to "add_school_data" can add the school data.
	1. User who has rights to "update" can edit/delete the school data.
	
**1. Non-functional requirement**
    1. Data is persisting in the Database  (School table)
    1. Application is modularized.
	1. Implemented proper loggers for debug.
	
**1. Modules and there purpose.**
  
    1. schoolmanagement-web ===>   Has UI and controller logic for create/edit/delete school data, asset publisher
	1. schoolmanagement     ====>  Service layer for CRUD operation, Indexer to index data, Permission management
	1. assetpublisher-fragment-hook ==> Override the asset-publiser-web jsp for integrate search form and to perform search on the school data.
	1. assetpublisher-web-resourcebundle-hook ==> Language file for assetpublisher-fragment-hook
	1. schoolmanagement-content-setup ===> Upgrade process for Create site template, role and assign define permission.
 
**1.	Known bugs.**
    1. On Create/Edit/Delet school data success message is not displaying. Same issue exist on create any asset in Asset publisher.
	1. On First access of "school data" page, we will get an error regarding permission (permission-resource not found error). We will not get this error on second access onwards.
       That is why we need to click on "School portlet" page to initiate the permission-resources properly..
	   
**1.	Pending task.**
    1. Junit test cases.

