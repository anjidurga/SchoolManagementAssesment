<%--
	SchoolData editing view.
--%>

<%@ include file="/init.jsp" %>

<%-- Generate add / edit action URL and set title. --%>

<c:choose>
	<c:when test="${not empty schoolData}">
		<portlet:actionURL name="<%= MVCCommandNames.EDIT_SCHOOLDATA %>" var="schoolActionURL">
			<portlet:param name="redirect" value="${param.redirect}" />
		</portlet:actionURL>

		<c:set value="edit-schooldata" var="editTitle" />
	</c:when>
	<c:otherwise>
		<portlet:actionURL name="<%= MVCCommandNames.ADD_SCHOOLDATA %>" var="schoolActionURL">
			<portlet:param name="redirect" value="${param.redirect}" />
		</portlet:actionURL>

		<c:set value="add-schooldata" var="editTitle" />
	</c:otherwise>
</c:choose>

<%-- Error messages. --%>

<liferay-ui:error key="error.schooldata-service-error" message="error.schooldata-service-error" />
<liferay-ui:error key="error.schooldata-schoolname-empty" message="error.schooldata-schoolname-empty" />
<liferay-ui:error key="error.schooldata-schooltype-empty " message="error.schooldata-schooltype-empty " />
<liferay-ui:error key="error.schooldata-cityname-empty" message="error.schooldata-cityname-empty" />

<div class="container-fluid-1280 edit-schooldata">
	<h1><liferay-ui:message key="${editTitle}" /></h1>

	<aui:model-context bean="${schoolData}" model="${schoolDataClass}" />

	<aui:form action="${schoolActionURL}" name="fm" onSubmit="event.preventDefault();">
		<aui:input field="schoolId" name="schoolId" type="hidden" />

		<aui:fieldset-group markupView="lexicon">
			<aui:fieldset>

				<%-- Title field. --%>

				<aui:input label="schoolName" maxlength="50" name="schoolName" type="text">

				</aui:input>

				<aui:input label="boardType" maxlength="10" name="schoolType" type="text">
					<aui:validator name="required" />
				</aui:input>

				<aui:input label="city" maxlength="10" name="city" size="10" type="text">
					<aui:validator name="required" />
				</aui:input>

				<aui:input label="noOfStudents" maxlength="6" name="noOfStudents" type="text">
					<aui:validator name="required" />
					<aui:validator name="digits" />
				</aui:input>

				<aui:input label="schoolRating" name="rating" type="text">
					<aui:validator name="required" />
					<aui:validator name="range">[1,5]</aui:validator>
				</aui:input>
			</aui:fieldset>
		</aui:fieldset-group>

		<%--Buttons. --%>

		<aui:button-row>
			<aui:button cssClass="btn btn-primary" type="submit" value="Update" />
			<aui:button cssClass="btn btn-secondary" onClick="${param.redirect}" type="cancel" />
		</aui:button-row>
	</aui:form>
</div>

<aui:script>

	
	AUI().ready(function() {

		$('#<portlet:namespace />fm').on('submit', function() {

			submitForm(document.<portlet:namespace />fm);
		});
	});

</aui:script>