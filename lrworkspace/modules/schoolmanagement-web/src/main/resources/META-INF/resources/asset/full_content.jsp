<%--
	This is for showing assignment full content in Asset Publisher portlet.
--%>

<%@ include file="/init.jsp" %>

<%
AssetRenderer<?> assetRenderer = (AssetRenderer<?>)request.getAttribute(WebKeys.ASSET_RENDERER);

String viewEntryURL = assetRenderer.getURLView(liferayPortletResponse, WindowState.MAXIMIZED);

SchoolData schooldata = (SchoolData)request.getAttribute("schooldata");
%>

<aui:a cssClass="title-link" href="<%= viewEntryURL %>">
	<h3 class="title">Anji Test : <%= schooldata.getSchoolName() %></h3>
</aui:a>

<div class="autofit-col autofit-col-expand">
	${schooldata.getCity()}
</div>