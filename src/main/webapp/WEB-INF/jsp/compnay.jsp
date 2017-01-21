<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>Spring MVC Auto Complete with JQuery</title>
<link rel="stylesheet" type="text/css"
	href="http://ajax.googleapis.com/ajax/libs/jqueryui/1.8/themes/base/jquery-ui.css" />

<script type="text/javascript"
	src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.2/jquery.min.js"></script>
<script type="text/javascript"
	src="https://ajax.googleapis.com/ajax/libs/jqueryui/1.8.18/jquery-ui.min.js"></script>
	<script type="text/javascript">
function split(val) {
    return val.split(/,\s*/);
}
function extractLast(term) {
    return split(term).pop();
}

$(document).ready(function() {

    $( "#ceos" ).autocomplete({
        source: '${pageContext.request.contextPath}/get_ceos_list'
    });

    $( "#companies").autocomplete({
        source: function (request, response) {
            $.getJSON("${pageContext.request.contextPath}/get_co_list", {
                term: extractLast(request.term)
            }, response);
        },
        search: function () {
            var term = extractLast(this.value);
            if (term.length < 1) {
                return false;
            }
        },
        focus: function () {
            return false;
        },
        select: function (event, ui) {
            var terms = split(this.value);
	        terms.pop();
            terms.push(ui.item.value);
            terms.push("");
            this.value = terms.join(", ");
            return false;
        }
    });

});
</script>
</head>
<body>

	<h2>Spring MVC Autocomplete with JQuery</h2>
	<form:form method="post" action="submit" modelAttribute="companyForm">
		<table>
			<tr>
				<th>CEOs</th>
				<td><form:input path="ceos" id="ceos" /></td>
			</tr>
			<tr>
				<th>Companies</th>
				<td><form:input path="companies" id="companies" /></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="Save" /> <input
					type="reset" value="Reset" /></td>
			</tr>
		</table>
		<br />

	</form:form>



</body>
</html>