# SWE Home Assignemnt in Java

## Steps to build application
```
$ mvn clean package
$ docker build -t gohealth/assignment
```

## Usage

To create an issue:

```
$ docker run gohealth/assignment --issue.id={id} --description="{description}" --link="{link}" --action=create
```

To close an issue:

```
$ docker run gohealth/assignment --issue.id={id} --description="{description}" --link="{link}" --action=close
```


