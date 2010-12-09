#! /usr/bin/perl
use MIME::Base64;
use Term::ReadKey;
use Time::localtime;
use IO::Socket;
print "Please enter your e-mail:\n";
$fr = <STDIN>;
chomp $fr;
while($fr!~/(\w+)\s(\w|\.)+\@(\w+)\.(\w+)/&&$fr!~/(\w|\.)+\@(\w+)\.(\w+)/){
	print "Error: not a e-mail, please re-enter:\n";
	$fr = <STDIN>;
	chomp $fr;
}
@from = split(' ',$fr);
print "Please enter e-mail to:\n";
$t = <STDIN>;
chomp $t;
while($t!~/(\w+)\s(\w|\.)+\@(\w+)\.(\w+)/&&$t!~/(\w|\.)+\@(\w+)\.(\w+)/){
	print "Error: not a e-mail, please re-enter:\n";
	$t = <STDIN>;
	chomp $t;
}
@to = split (' ',$t);
print "Please enter name of the letter:\n";
$name = <STDIN>;
chomp $name;
while (length($name)==0){
		print "Error:please re-enter\n";
		$name = <STDIN>;
		chomp $name;
}
print "Please enter the txt file with letter\n";
$file_name = <STDIN>;
chomp $file_name;
while (!-e $file_name){
	print "Error: no such file, please re-enter\n";
	$file_name = <STDIN>;
	chomp $file_name;
	}
print "Would you like to attach any file?[y|N]\n";
ReadMode 4;
while (not defined ($key = ReadKey(0))) {
		next;
}
ReadMode 0;
lc $key;
if ($key eq 'y'){
	print "Print the name of file you want to attach\n";
	$attach_name = <STDIN>;
	chomp $attach_name;
	while(!-e $attach_name){
		print "Error: no such file,please re-enter\n";
		$attach_name = <STDIN>;
		chomp $attach_name;
	}
}
print "What would you like to do?\n1.Save *.eml file\n2.Send to $from[1]";
ReadMode 4;
while (not defined ($key = ReadKey(0))) {
		next;
}
ReadMode 0;
open EML,">$name.eml";
$bn = base64($name);	
$bsn = base64($from[0]);
$bgn = base64($to[0]);
$bn=~s/\r|\n//g;
$bsn=~s/\r|\n//g;
$bgn=~s/\r|\n//g;
@date = split(" ",ctime());
$letter[0] = "From:$from[1]\n";
$letter[1] = "To:$to[1]\n";
$letter[2] = "Subject:=?utf-8?B?$bn?=\n";
$letter[3] = "Date:$date[0], $date[2] $date[1] $date[4] $date[3] UTC\n";
$letter[4] = "MIME-Version: 1.0\n";
$letter[5] = "Content-Type: multipart/mixed; boundary=\"frontier\"\n";
$letter[6] = "\n";
$letter[7] = "--frontier\n";
$letter[8] = "Content-Type: text/plain; charset=windows-1251\n";
$letter[9] = "Content-Transfer-Encoding: base64\n";
$letter[10] = "\n";
open FILE, "$file_name\n";
$/ = "\0";
$string = <FILE>;
$dstring = base64($string);
$letter[11] = $dstring."\n";
$letter[12] = "--frontier\n";
if (defined $attach_name){
	$/ = "\0";
	open ATTACH, "$attach_name";
	binmode ATTACH;
	while(<ATTACH>){
		$att_str.=$_;
	}
	$b_att = base64($att_str);
$letter[13] = "Content-Type: image/gif\n";
$letter[14] = "Content-Transfer-Encoding: base64\n";
$letter[15] = "Content-Disposition: attachment;"."filename=\"$attach_name\"\n";
$letter[16] = "Content-Id: x\n";
$letter[17] = "\n";
$letter[18] = "$b_att\n";
$letter[19] = "--frontier\n";
}
$letter[20] = ".\n";
if ($key==1){
	$letter[0] = "From: =?utf-8?B?$bsn?= $from[1]\n";
	$letter[1] = "To:=?utf-8?B?$bgn?= $to[1]\n";
	$letter[2] = "Subject:=?utf-8?B?$bn?=\n";
	$letter[3] = "Date:$date[0], $date[2] $date[1] $date[4] $date[3] UTC\n";
	for (0..20){
		print EML $letter[$_];
	}
	print "Compleated\n";
}
else{
	$letter[0] = "From:$from[0]\n";
	$letter[1] = "To:$to[0]\n";
	$letter[2] = "Subject:=?utf-8?B?$bn?=\n";
	$letter[3] = "Date:$date[0], $date[2] $date[1] $date[4] $date[3] UTC\n";
	$/="\n";
	print "Please enter your pass:\n";
	ReadMode('noecho');
	$pass = ReadLine(0);
	ReadMode(0);
	chomp $pass;
	($to,$to) = split("@",$to[1]);
	$to=~s/\r|\n//g;
	$socket = IO::Socket::INET->new("smtp.mail.ru:25") or die "ERROR: $!\n";
	if(ReadReply()!~/220/){
		print "ERROR: no connection\n";
		$socket->close();
		exit
	}
	$socket->print ("helo lo\n");
	if(ReadReply() != 250){
		print "ERROR: no greetings from server\n";
		$socket->close();
		exit
	}
	$socket->print("AUTH LOGIN\n");
	if(ReadReply() ne 334){
		print "Error: authorization fail = $message\n";
		$socket->close();
		exit
	}
	$socket->print(encode_base64($from[0]).encode_base64("$pass"));
	ReadReply();
	if(ReadReply() ne 235){
		print "Authorization fail = $message\n";
		$socket->close();
		exit}
	$socket->print('mail from: '."$from[0]\n");
	if(ReadReply() ne 250){
		print "Error in sender e-mail= $message\n";
		$socket->close();
		exit
	}
	$socket->print("rcpt to: $to[0]\n");
	if(ReadReply() ne 250){
		print "Eror in getter e-mail = $message\n";
		$socket->close();
		exit
	}
	$socket->print("data\n");
	if(ReadReply() ne 354){
		print "Error in data stream = $message\n";
		$socket->close();
		exit
	}
	$longmes = join('',@letter);
	$socket->print($longmes);
	if(ReadReply() ne 250){print "Error sending mail = $message\n"; $socket->close(); exit}
$socket->close();
print "Compleated\n";
}
sub base64($){
	my $s = shift;
	my @ans;
	@s = split "", $s;
	$al = 'ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/';
	@al = split "", $al;
	$a = unpack "B*", $s;
	@a = split "", $a;
	$n = @a;
	for $i(0..int(($n + 5) / 6) - 1)
	{
		$ans[$i] = $ans[$i] * 2 + $a[$i * 6 + $_] for (0..5);
	}
	my $ans = "";
	$ans.=$al[$_] for (@ans);
	$ans;
	if(scalar(@a) % 24 != 0)
	{
		$ans.="=" if scalar(@a) % 24 == 16;
		$ans.="==" if scalar(@a) % 24 == 8;
	}
return $ans;
	}
sub ReadReply(){
print "$r\n";
$val = 1;
while($val eq 1){
$r = <$socket>;
$val = $r =~ m/^\d{3}-/g;
}
($reply,$message) = split(/ /,$r,2);
return $reply;
}