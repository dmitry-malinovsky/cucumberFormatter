1. Instal and run ElasticSearch instance
2. Install and run Kibana instance
3. Formatter is configured with following properties:
    Send $(BUILD.NUMBER) from Jenkins to System.getProperty("-Djenkins.build.number");
    Send $(JOB.NAME) from Jenkins to System.getProperty("-Djenkins.job.name");
    update endOfScenarioLifeCycle with your ElasticSearchURL (default is http://localhost:9200/testing/test-1)
4. Elastic Search can accept any raw Json, and parse it automatically, or you can pass it a template.
i.e.

{
 "index_patterns" : "test-*", // or change to index you want, note that "*" means - read evetything after "test-"
 "mappings": {
	"regression-test-1": {
		"properties" : { // here you set format and type of your fields, make sure that name is exactly the same as in your Json
			"date": { "type": "date",
			"format": "yyyy-MM-dd HH:mm"},
			"output": { "type": "keyword"}
				}
			}
		}
	}
}