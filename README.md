## struthio
syncs ostrich stats remotely

## motivation
Ostrich stats can be used to understand the health of a cluster, but they need to leave
the individual boxes first.  Today, the canonical way to do this is to implement individual
StatsReporters per protocol, as seen in the GraphiteStatsLogger.  It should be easy to send
stats through a generic interface.  Struthio lets anyone receive all of another instance's stats.

## todo
example server
