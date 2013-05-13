namespace scala com.mosesn.struthio.thrift

struct distribution {
  1: list<i64> buckets,
  2: i64 count,
  3: i64 sum
}

service StatsService {
  void syncCounters(1: map<string, i64> counters),
  void syncMetrics(1: map<string, distribution> metrics),
  void syncGauges(1: map<string, double> gauges),
  void syncLabels(1: map<string, string> labels)
}
