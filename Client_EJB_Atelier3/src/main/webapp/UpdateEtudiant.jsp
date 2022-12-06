<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
            <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">

<meta charset="ISO-8859-1">
<title>Update Etudiant</title>
</head>
<body>
<div class="row">
    <div class="col-md-6 mx-auto mt-5">
        <form action="etudiant?action=update" method="POST" >
         <input type="hidden" class="form-control" name="id" value="${etudiant.id_etudiant}">
            <div class="mb-3">
                <label class="form-label">Nom</label>
                <input type="text" class="form-control" name="nom" value="${etudiant.nom}">
                
            </div>
            <div class="mb-3">
                <label class="form-label">Prenom</label>
                <input type="text" class="form-control" name="prenom" value="${etudiant.prenom}">
            </div>
          <div class="mb-3">
                <label class="form-label">cne</label>
                <input type="text" class="form-control" name="cne" value="${etudiant.cne}">
            </div>
            <div class="mb-3">
                <label class="form-label">niveau</label>
                <input type="text" class="form-control" name="niveau" value="${etudiant.niveau}">
            </div>
            <div class="mb-3">
                <label class="form-label">adresse</label>
                <input type="text" class="form-control" name="adresse" value="${etudiant.adresse}">
            </div>
           
            <div class="d-grid gap-2 ">
                <button type="submit" class="btn btn-primary "><i class="fas fa-save"></i> Modifier</button>
            </div>   
        </form>
    </div>
</div>

</body>
</html>