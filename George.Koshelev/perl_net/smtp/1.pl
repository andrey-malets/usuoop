#!/usr/bin/perl
use MIME::Base64;
use IO::Socket;
$auth = encode_base64("\000george.koshslev\@gmail.com\000nYr5enyS");
$socket = IO::Socket::INET->new("smtp.mail.ru:25") or die "ERROR: $!\n";
ReadReply();
$socket->print("helo lo\n");
ReadReply();
$socket->print("starttls\n");
ReadReply();

$socket->print("auth plain $auth\n");
ReadReply();

$socket->print("mail from: <george.koshelev@gmail.com>\n");
ReadReply();

sub ReadReply(){
$val = 1;
while($val eq 1){
$r = <$socket>;
print "$r\n";
$val = $r =~ m/^\d{3}-/g;
}
($reply,$message) = split(/ /,$r,2);
return $reply;
}