namespace scala com.mosesn.struthio.thrift

service StatsService {
  void sendStats(1: map<string, double> stats),
  void sendStatuses(1: map<string, string> statuses)
}