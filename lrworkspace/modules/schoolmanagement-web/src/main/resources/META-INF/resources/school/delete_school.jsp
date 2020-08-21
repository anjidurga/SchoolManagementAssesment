<%--
	SchoolData editing view.
--%>

<%@ include file="/init.jsp" %>

<%-- Generate add / edit action URL and set title. --%>

<portlet:actionURL name="<%= MVCCommandNames.DELETE_SCHOOLDATA %>" var="schoolDeleteActionURL">
	<portlet:param name="redirect" value="${param.redirect}" />
</portlet:actionURL>

<%-- Error messages. --%>

<div class="container-fluid-1280 edit-schooldata">
	<h1>
		<liferay-ui:message key="delete-schooldata" />
	</h1>

	<aui:model-context bean="${schoolData}" model="${schoolDataClass}" />

	<aui:form
		action="${schoolDeleteActionURL}"
		name="fm"
		onSubmit="event.preventDefault();"
	>
		<aui:input field="schoolId" name="schoolId" type="hidden" />

		<aui:fieldset-group markupView="lexicon">
			<aui:fieldset label="">
				<aui:row>
					<aui:col width="50">
						<liferay-ui:message key="school-delete-message" />&nbsp;&nbsp;<b>${schoolData.schoolName}</b>
					</aui:col>
				</aui:row>
			</aui:fieldset>
		</aui:fieldset-group>

		<aui:button-row>
			<aui:button  cssClass="btn btn-primary" type="submit" value="Delete" />

			<aui:button
				cssClass="btn btn-secondary"
				onClick="${param.redirect}"
				type="cancel"
			/>
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