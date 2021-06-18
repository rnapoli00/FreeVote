<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

	<a href="<%=response.encodeURL("/FreeVote/home.jsp")%>">FreeVote</a>  <!--LOGO-->
	
	<% boolean isAdmin = request.getSession(false) != null && request.getSession(false).getAttribute("adminRoles")!= null;

	if(isAdmin) { %>
		<a href="<%=response.encodeURL("/FreeVote/admin/interfacciaAdmin.jsp")%>">FreeVote Admin</a> <%
	} %>
	<br/>
	<a href="<%=response.encodeURL("/FreeVote/PartitiControl")%>">Partiti</a>
	<a href="<%=response.encodeURL("/FreeVote/Referendum")%>">Referendum</a>
	<a href="<%=response.encodeURL("/FreeVote/risultati.html")%>">Risultati Live</a>
	<a href="<%=response.encodeURL("/FreeVote/statistiche.html")%>">Statistiche Live</a>
	<!--POLITICHE-->
	<a href="<%=response.encodeURL("/FreeVote/Risultati")%>">Risultati Generali</a> 
	<a href="<%=response.encodeURL("/FreeVote/risultatiPerEta.jsp")%>">Risultati per fascia d'et&agrave;</a>
	<a href="<%=response.encodeURL("/FreeVote/risultatipolitcheregioni.html")%>">Risultati per Regione</a>
	<!--REFERENDUM-->
	<a href="<%=response.encodeURL("/FreeVote/risultatireferendum.html")%>">Risultati Generali Referendum</a>
	<a href="<%=response.encodeURL("/FreeVote/infoEContatti.jsp")%>">Info e contatti</a>
	
	<% boolean isElettore = request.getSession(false) != null && request.getSession(false).getAttribute("elettoreRoles")!= null;

	if (isElettore) { %>
		<a href="<%=response.encodeURL("/FreeVote/elettore/schedaVoto.jsp")%>">Vai alla scheda</a> <%
	} 
	
	if (isElettore || isAdmin) {
		%>
		<a href="<%=response.encodeURL("/FreeVote/Logout")%>">Logout</a> <%
	}
	%>
