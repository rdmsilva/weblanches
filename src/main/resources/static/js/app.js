$( document ).ready(function() {

    $("#addIngredientes").click(function(){
        $('.mini.modal').modal('show');
    });

});

function adicionarIngrediente(idIngrediente) {
    $("#frmLanche").attr("action", "/addIngrediente/?idIngrediente="+idIngrediente);
    $("#frmLanche").submit();
}