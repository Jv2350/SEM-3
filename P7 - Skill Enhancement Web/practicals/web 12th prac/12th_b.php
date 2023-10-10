<?php
echo "Writing a file";
$filename = "tmp.txt";
$file=fopen( $filename,"w" );
if($file==false)
{
echo "Error in opening new file";
}
fwrite( $file,"This is a simple test\n" );
fclose( $file );
?>