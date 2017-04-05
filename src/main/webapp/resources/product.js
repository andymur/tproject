<script>
$("#zoom_02").elevateZoom({gallery:'gal1', easing : true, responsive: true, cursor: 'pointer', galleryActiveClass: 'active', responsive:true, });
$('.thumbs ul li:first a').addClass('active');
</script>

<script type="text/javascript">
    function subtractQty(){
        if(document.getElementById("qty").value - 1 < 0)
            return;
        else
            document.getElementById("qty").value--;
    }
    </script>

    <script>
    function toggleChevron(e) {
        $(e.target)
            .prev('.panel-heading')
            .find("i.fa")
            .toggleClass('fa-plus-square-o fa-minus-square-o');
    }
$('#accordion').on('hidden.bs.collapse', toggleChevron);
$('#accordion').on('shown.bs.collapse', toggleChevron);
</script>