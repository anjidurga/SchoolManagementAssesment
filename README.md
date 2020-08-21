

1.Softwares and their versions used for development and deployement of the project 

	a. Liferay Community Edition Portal 7.1.0 CE GA1 (Judson / Build 7100 / July 2, 2018)
	b. Mysql- 5.7.20
	c. Liferay workspace with Gradle build tool. 	
		
2. Installation steps
  2.1 Deploy the components
  
    a. Clone the Liferay workspace from the git location 
	b. Import the LW into LDS or any editor.
	c. Change the server path in gradle.properties.
	d. Run the deploy task.
	
	 -- or ---
	
	a. Downlod the jar from folder "Step_1-jars", then copy the jars into deploy folder
	b. Downlod the jar from folder "Step_2-jars", then copy the jar into deploy folder.
	
  2.2 Liferay admininstration setup.    
        a. Login to liferay with admin user.
	b. Verify whether site-template and role has been created from the upgrade process.
	c. For that, Go-to Site --> Site Templates . Check School Management Site template exist.
	d. Go-to Roles --> Regular role. Check whether role "school_mng_admin" created. If yes, select the "school_mng_admin" and check the "define permission" for that role.
	   This role should have access to "school-web-portlet".
	   
	e. Go-to Sites --> Sites --> Verify whether "School Management" Site created.
	
	f. Acess the url http://localhost:8089/web/school-management/school-portlet  (To initiate all permission control : Note: "This page is not require, it is just for one time activity")
	g. Access the url http://localhost:8089/web/school-management/school-data
	
	h. Create a user and assign to role "schoolmng_admin".	
	i Perform CRUD operation in "School Data" page.
	
     
3.	Functionality
        a. Logged in user can view the school data and can search the data.
	b. User who has rights to "add_school_data" can add the school data.
	c. User who has rights to "update" can edit/delete the school data.
	
4. Non-functional requirement
       a. Data is persisting in the Database  (School table)
       b. Application is modularized.
       c. Implemented proper loggers for debug.
	
5. Modules and there purpose.
  
        a. schoolmanagement-web ===>   Has UI create/edit/delete,asset publisher
	b. schoolmanagement     ====>  Service layer for CRUD operation, Indexer to index data, Permission checker.
	c. assetpublisher-fragment-hook ==> Override the asset-publiser-web jsp for integrate search form and to perform search on the school data.
	c. assetpublisher-web-resourcebundle-hook ==> Language file for assetpublisher-fragment-hook
	d. schoolmanagement-content-setup ===> Upgrade process for Create site template, role and assign define permission.
 
6.	Known bugs.
        a. On Create/Edit/Delet success message is not displaying. Same issue exist on create any asset created in Asset publisher.
	b. On First access of "school data" page, we get an error regarding permission. We will not get this error on second access.
       That is why we need to click on "School portlet" page to initiate the permission properly..
	   
7.	Pending task.
        a. Unit test cases.


