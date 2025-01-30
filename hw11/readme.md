- **_проект с добавленными зависимостями_**

![pom.xml](images/pom.png)

- **_файл настройки prometheus_**

![prometheus.yml](images/prometheus_1.png)

**Примечание:** _Так как все взаимодействие идет внутри docker-a, то и настройку **target (tasks:8080)**, нужно писать
ссылку на контейнер, а не **localhost:8080**_

![prometheus-web](images/prometheus_2.png)

- **_скриншот Grafana с добавленными контрольными точками._**

![grafana-config](images/grafana_1.png)

**Примечание:** Настройку **Connection**, также прописываем название контейнера:порт **(http://prometheus:9090)**

![grafana-config](images/grafana_2.png)



