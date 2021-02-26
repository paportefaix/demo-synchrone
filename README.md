# Appel synchrone

## Benchmark

Bench fait en ligne de comande à l'aide de la commande suviante au deuxième lancement afin de faire chauffer la JVM:
ab -c 100 -n 10000 http://localhost:8080/projects-sync

Server Software:
Server Hostname:        localhost
Server Port:            8080

Document Path:          /projects-sync
Document Length:        1853 bytes

Concurrency Level:      100
Time taken for tests:   30.310 seconds
Complete requests:      10000
Failed requests:        0
Total transferred:      19580000 bytes
HTML transferred:       18530000 bytes
Requests per second:    329.93 [#/sec] (mean)
Time per request:       303.096 [ms] (mean)
Time per request:       3.031 [ms] (mean, across all concurrent requests)
Transfer rate:          630.86 [Kbytes/sec] received

Connection Times (ms)
              min  mean[+/-sd] median   max
Connect:        0    0   0.6      0       6
Processing:   300  302   1.2    301     312
Waiting:      300  301   1.0    301     311
Total:        301  302   1.5    302     315

Percentage of the requests served within a certain time (ms)
  50%    302
  66%    302
  75%    302
  80%    303
  90%    304
  95%    305
  98%    307
  99%    309
 100%    315 (longest request)
