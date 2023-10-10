<?php
$num = 139;
$r = 0;
while($num != 0)
{
$r = $r * 10 + $num % 10;
$num = (int)($num / 10);
}
echo "Reverse Number:",$r;
?>