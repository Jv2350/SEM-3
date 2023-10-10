<?php
$n=10;
$a=0;
$b=1;
echo "$a $b";//01
for($i=3; $i<=$n; $i++)
{
echo $c=$a+$b;
echo " ";
$a=$b;
$b=$c;
}
echo "fibonaaci series of 1 to 10 "
?>