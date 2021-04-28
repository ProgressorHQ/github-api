# Java API for GitHub

Fork of https://github.com/hub4j/github-api.

To publish the fork to GitHub packages:

1. Create/modify `~/.m2/settings.xml` to contain the following:

```xml

<settings>

    <!--... -->

    <activeProfiles>
        <activeProfile>github</activeProfile>
    </activeProfiles>

    <profiles>
        <profile>
            <id>github</id>
            <repositories>
                <repository>
                    <id>github</id>
                    <url>https://maven.pkg.github.com/progressorhq/*</url>
                    <snapshots>
                        <enabled>true</enabled>
                    </snapshots>
                </repository>
            </repositories>
        </profile>
    </profiles>

    <servers>
        <server>
            <id>github</id>
            <username>*YOUR_USERNAME*</username>
            <password>*YOUR_GITHUB_TOKEN*</password>
        </server>
    </servers>
</settings>
```

2. Invoke `./mvnw deploy` from the project root.
