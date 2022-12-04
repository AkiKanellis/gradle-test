#!/usr/bin/env just --justfile

# renovate: datasource=docker depName=github/super-linter
super_linter_version := "slim-v4.9.7@sha256:900277f36d47d5ddc460d901ea9dfcb1d348f7390066f800a0895cd88866b31f" # editorconfig-checker-disable-line

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
  -e FILTER_REGEX_EXCLUDE=.*vault\.yml \
  {{extra_args}} \
  -v {{justfile_directory()}}:/tmp/lint \
  github/super-linter:{{super_linter_version}}

# Run the tests
test:
  echo "no-op"

# Clean generated files
clean:
  echo "no-op"
