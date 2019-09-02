<?php 
    
    $x="https://congress.api.sunlightfoundation.com/legislators?apikey=c6b21911932d4f0cb714b073c5ff5f31&per_page=all";
    $a=file_get_contents($x);
    echo $a; 

?>
    
