# heylogs

[![Download](https://img.shields.io/github/release/nbbrd/heylogs.svg)](https://github.com/nbbrd/heylogs/releases/latest)

`heylogs` is a set of tools to deal with the [keep-a-changelog format](https://keepachangelog.com),
a format designed to be human-readable.
It can be used as a linter in interactive sessions and automations.

Key points:

- Available as a library, a [command-line tool](#installation) and a [Maven plugin](#maven-plugin)
- Java 8 minimum requirement

Features:

- Summarizes content
- Checks format
- Extracts versions

## Command-line tool

Heylogs CLI runs on any desktop operating system such as Microsoft Windows, 
Solaris OS, Apple macOS, Ubuntu and other various Linux distributions. 
It requires a Java SE Runtime Environment (JRE) version 8 or later to run on such as OpenJDK.

### Installation

The easiest way of installing the CLI is to use a package manager.  
Each operating system has its own manager. See the list below for specific instructions.

#### Scoop

![WINDOWS]

```shell
scoop bucket add nbbrd https://github.com/nbbrd/scoop-nbbrd.git
scoop install heylogs
```

#### Homebrew

![MACOS] ![LINUX]

```shell
brew install nbbrd/tap/heylogs
```

#### JBang

The CLI can be run by JBang almost anywhere using one of these options:
- Specific version (Maven coordinates): `com.github.nbbrd.heylogs:heylogs-cli:_VERSION_:bin`
- Latest version (JBang catalog): `heylogs@nbbrd`

![WINDOWS] ![MACOS] ![LINUX]

```shell
jbang com.github.nbbrd.heylogs:heylogs-cli:_VERSION_:bin <command> [<args>]
```

![GITHUB]

```yml
- uses: jbangdev/jbang-action@v0.110.1
  with:
    script: com.github.nbbrd.heylogs:heylogs-cli:_VERSION_:bin
    scriptargs: "<command> [<args>]"
```
_Note that the trust parameter is required if the catalog is used instead of the Maven coordinates:  
`trust: https://github.com/nbbrd/jbang-catalog`_

![DOCKER]

```shell
docker run -v `pwd`:/ws --workdir=/ws jbangdev/jbang-action com.github.nbbrd.heylogs:heylogs-cli:_VERSION_:bin <command> [<args>]
```

#### Maven command-line

![WINDOWS] ![MACOS] ![LINUX] ![GITHUB]

```shell
mvn dependency:copy -Dartifact=com.github.nbbrd.heylogs:heylogs-cli:_VERSION_:jar:bin -DoutputDirectory=. -Dmdep.stripVersion -q
java -jar heylogs-cli-bin.jar <command> [<args>]
```

#### Zero installation

![WINDOWS] ![MACOS] ![LINUX] ![GITHUB]

The CLI is a single executable jar, so it doesn't need to be installed to be used.  
To use the CLI without installing it:

1. Download the latest jar binary (`heylogs-_VERSION_-bin.jar`) at:  
   [https://github.com/nbbrd/heylogs/releases/latest](https://github.com/nbbrd/heylogs/releases/latest)
2. Run this jar by calling:  
   `java -jar heylogs-cli-_VERSION_-bin.jar <command> [<args>]`

## Maven plugin

Heylogs is available as a Maven plugin and therefore may be part of the build process.

The following script checks the changelog on every build:

```xml
<plugin>
    <groupId>com.github.nbbrd.heylogs</groupId>
    <artifactId>heylogs-maven-plugin</artifactId>
    <version>${heylogs.version}</version>
    <executions>
        <execution>
            <id>check-changelog</id>
            <goals>
                <goal>check</goal>
            </goals>
            <inherited>false</inherited>
            <configuration>
                <semver>true</semver>
            </configuration>
        </execution>
    </executions>
</plugin>
```

The following script extracts the latest version from the changelog during a release:

```xml
<profile>
    <id>release</id>
    <build>
        <plugins>
            <plugin>
                <groupId>com.github.nbbrd.heylogs</groupId>
                <artifactId>heylogs-maven-plugin</artifactId>
                <version>${heylogs.version}</version>
                <executions>
                    <execution>
                        <id>extract-changelog</id>
                        <goals>
                            <goal>extract</goal>
                        </goals>
                    </execution>
                </executions>
            </plugin>
        </plugins>
    </build>
</profile>
```

## Developing

This project is written in Java and uses [Apache Maven](https://maven.apache.org/) as a build tool.  
It requires [Java 8 as minimum version](https://whichjdk.com/) and all its dependencies are hosted
on [Maven Central](https://search.maven.org/).

The code can be build using any IDE or by just type-in the following commands in a terminal:

```shell
git clone https://github.com/nbbrd/heylogs.git
cd heylogs
mvn clean install
```

## Contributing

Any contribution is welcome and should be done through pull requests and/or issues.

## Licensing

The code of this project is licensed under
the [European Union Public Licence (EUPL)](https://joinup.ec.europa.eu/page/eupl-text-11-12).

[WINDOWS]: https://img.shields.io/badge/-WINDOWS-068C09

[MACOS]: https://img.shields.io/badge/-MACOS-5319E7

[LINUX]: https://img.shields.io/badge/-LINUX-BC0250

[DOCKER]: https://img.shields.io/badge/-DOCKER-E2BC4A

[GITHUB]: https://img.shields.io/badge/-GITHUB-e4e669

[MAVEN]: https://img.shields.io/badge/-MAVEN-e4e669

[GRADLE]: https://img.shields.io/badge/-GRADLE-F813F7
