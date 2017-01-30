README

Usage:
The main java class is LTVReport.java.
Input: 
In the main function, the user can define the input file and the topK customers with the highest Simple Lifetime Value. 
String inputFile = "events.txt";
int topK = 2;

The example input files include event.txt, SimpleTestA.txt, SimpleTestB.txt and SimpleTestC.txt. 

Output:
The example output files:
Top2_output_for_SimpleTestC.txt means the outputFile for top2 customer result generated from inputFile SimpleTestC.txt.
Top3_output_for_events.txt means the outputFile for top3 customer result generated from inputFile events.txt.


Explanation for processing inputFile SimpleTestC.txt:
 
[{"type":	CUSTOMER,	verb:	NEW,	key:	A,			event_time:	2017-03-06:12:46.384Z,		last_name:	Green,	adr_city:	Stonybrook,	adr_state:	CA},	   
{"type":	SITE_VISIT,	verb:	NEW,	key:	visit01,	event_time:	2017-03-06:12:45:52.041Z,	customer_id:	A,	tags:	{"some	key":	some value}},	   
{"type":	ORDER,		verb:	NEW,	key:	order01,	event_time:	2017-03-06:12:55.55.555Z,	customer_id:	A,	total_amount:	1.00 USD},			   
{"type":	CUSTOMER,	verb:	NEW,	key:	B,			event_time:	2017-02-06:12:46.384Z,		last_name:	Rizzo,	adr_city:	Smithtown,	adr_state:	NY},	   
{"type":	SITE_VISIT,	verb:	NEW,	key:	visit02,	event_time:	2017-02-06:12:45:52.041Z,	customer_id:	B,	tags:	{"some	key":	some value}},	   
{"type":	ORDER,		verb:	NEW,	key:	order02,	event_time:	2017-02-06:12:55.55.555Z,	customer_id:	B,	total_amount:	2.00 USD},			   
{"type":	ORDER,		verb:	UPDATE,	key:	order02,	event_time:	2017-02-26:12:55.55.555Z,	customer_id:	B,	total_amount:	3.00 USD},			   
{"type":	CUSTOMER,	verb:	NEW,	key:	C,			event_time:	2017-02-06:12:46.384Z,		last_name:	Smith,	adr_city:	Smithtown,	adr_state:	NY},	   
{"type":	SITE_VISIT,	verb:	NEW,	key:	visit03,	event_time:	2017-02-06:12:45:52.041Z,	customer_id:	C,	tags:	{"some	key":	some value}},	   
{"type":	ORDER,		verb:	NEW,	key:	order03,	event_time:	2017-02-06:12:55.55.555Z,	customer_id:	C,	total_amount:	8.00 USD},			   
{"type":	ORDER,		verb:	UPDATE,	key:	order03,	event_time:	2017-02-26:12:55.55.555Z,	customer_id:	C,	total_amount:	4.00 USD}]			 

Here we have customer A, B and C, 
for this time range: 2017-02-06 ~ 2017-03-06: week 6 - 10 + 1 = 5
A spends $1.00:  1/5 * 52 * 10 = 104.00
B spends $3.00:  3/5 * 52 * 10 = 312.00
C spends $4.00:  4/5 * 52 * 10 = 416.00

This is consistent with the output file Top2_output_for_SimpleTestC.txt: 
Rank      LTV (USD)       customer_ID      Last_Name
 1         416.00                   C       Smith
 2         312.00                   B       Rizzo

A word about time complexity of the program:
Currently, the TopXSimpleLTVCustomers(x, D) function has O(nlogx) complexity, there n is the total number of customers. In the future, a combination of data structures (like an arrayList and one or two hashmaps) can be used to replace the current data container: private HashMap<String, LTVData> m_mapLTV. That way, the calculation burden can be shifted to the ingestion of each event (amortized constant time per event ingestion), and the final query of TopXSimpleLTVCustomers(x, D) can be reduced to constant time, because all the results are already readily available in the new data structures.

