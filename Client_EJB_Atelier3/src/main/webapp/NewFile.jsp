<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-
8859-1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
<title>Etudiants</title>
</head>
<body>
<div class="row">
    <div class="col-12">
        <div class="card">
            <div class="card-body">
                <h4 class="card-title">Liste des Etudiants</h4>
     <a href="etudiant?action=ajouterEtudiant"><button type="button" data-bs-toggle="modal" data-bs-target="#AddModal" class="btn btn-default  bg-primary btn-sm"><i class="fas fa-plus-circle"></i>Ajouter nouveau Etudiant</button></a>   
                <div class="table-responsive mt-3">
                    <table class="table align-middle text-nowrap">
                        <thead>
                            <tr>
                                <th class="text-dark font-medium fs-4">ID</th>
                                <th class="text-dark font-medium fs-4">Nom</th>
                                <th class="text-dark font-medium fs-4">Prenom</th>
                                <th class="text-dark font-medium fs-4">cne</th>
                                <th class="text-dark font-medium fs-4">niveau</th>
                                <th class="text-dark font-medium fs-4">adresse</th>
                                <th class="text-dark font-medium fs-4">Action</th>
                            </tr>
                        </thead>
                        <tbody>
                        <c:forEach items="${listetudiants}" var="etu">
                            <tr >
                               <td class="fs-4">${etu.id_etudiant}</td>
                                <td class="fs-4">${etu.nom}</td>	
                                <td class="fs-4">${etu.prenom}</td>
                                <td class="fs-4">${etu.cne}</td>
                                <td class="fs-4">${etu.niveau}</td>
                                <td class="fs-4">${etu.adresse}</td>                                 
                                <td>
                                    <h5 class="mb-0 fw-normal">
                                     <a href="etudiant?action=delete&id=<c:out value='${etu.id_etudiant}' />"><button type="button" class="btn btn-default btn-sm">delete</button></a>   
                                     <a href="etudiant?action=updateEtudiant&id=<c:out value='${etu.id_etudiant}' />"><button type="button" class="btn btn-default btn-sm">update</button></a>   
                                    </h5>
                                </td>
                            </tr>
                            </c:forEach>
                        </tbody>
                        
                    </table>
                </div>
            </div>
        </div>

    </div>
</div>
</body>
</html>