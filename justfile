#!/usr/bin/env just --justfile

# renovate: datasource=docker depName=github/super-linter
super_linter_version := "slim-v4.10.0@sha256:1d86cb6bb4730483175ac4c8a641751554c320db73ae6075f3f822618c3e5ea5" # editorconfig-checker-disable-line

@_default:
  just --list

# Install project dependencies
install:
  ./gradlew dependencies

# Lint the project
lint *extra_args:
  docker run \
  -e RUN_LOCAL=true \
  -e DEFAULT_BRANCH=main \
  -e IGNORE_GENERATED_FILES=true \
  -e IGNORE_GITIGNORED_FILES=true \
  -e YAML_ERROR_ON_WARNING=true \
  -e FILTER_REGEX_EXCLUDE=.*gradlew.* \
  {{extra_args}} \
  -v {{justfile_directory()}}:/tmp/lint \
  github/super-linter:{{super_linter_version}}

# Run the tests
test:
  ./gradlew test

# Clean generated files
clean:
  ./gradlew clean
