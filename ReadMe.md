# Read Me First
h2 console: http://localhost:8090/h2-console/

Please check scheduled job to update expired flag.

server Port: 8090

Request URL: http://localhost:8090/transaction/assign

Request Payload :
{
"tradeId" :"T1",
"version" : 3,
"counterPartyId" :"CP-1",
"bookId" :"B1",
"maturityDate" :"05/12/2022",
"createdDate" :"06/12/2022",
"expired":"N"
}
