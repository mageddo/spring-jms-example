# Running

	$ gradle bootRun
	system is up!!
	

Testing it

	$ curl -X GET localhost:8090/ping?who=Elvis
	the ping was sent, wait for the receiver

The server output

	Sending a new message.
	message was sent
	PingReceiver 1 sleeping 1482 ms....
	1 back to work!
	the receive read the ping message <ping from: Elvis!>

