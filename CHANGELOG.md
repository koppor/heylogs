# Changelog

All notable changes to this project will be documented in this file.

The format is based on [Keep a Changelog](https://keepachangelog.com/en/1.0.0/), and this project adheres
to [Semantic Versioning](https://semver.org/spec/v2.0.0.html).

## [Unreleased]

## [0.7.1] - 2023-10-19

### Fixed

- Fix missing error code when problems are found in check command [#159](https://github.com/nbbrd/jbang-catalog/issues/159)

## [0.7.0] - 2023-10-10

This release adds support for a custom separator between version and date. It also provides some basic documentation.

### Added

- Add support for en dash (`U+2013`) and em dash (`U+2014`) as separator between version and date by [@koppor](https://github.com/koppor) [#140](https://github.com/nbbrd/heylogs/issues/140)
- Add basic documentation [#4](https://github.com/nbbrd/heylogs/issues/4)

### Fixed

- Fix project description in release distribution [#1](https://github.com/nbbrd/jbang-catalog/issues/1)

### Changed

- Rename rule `entry-for-every-versions` to `all-h2-contain-a-version`[@koppor](https://github.com/koppor) [#141](https://github.com/nbbrd/heylogs/issues/141)

## [0.6.0] - 2023-06-20

This release improves extension points and also aligns features of Maven plugin and CLI.

### Added

- Add extension point for scan formatting [#119](https://github.com/nbbrd/heylogs/issues/119)
- Add scan mojo [#120](https://github.com/nbbrd/heylogs/issues/120)
- Add list command and mojo [#120](https://github.com/nbbrd/heylogs/issues/120)

### Changed

- Refactor extension points [#119](https://github.com/nbbrd/heylogs/issues/119)
- Merge old list command into extract command [#120](https://github.com/nbbrd/heylogs/issues/120)
- Improve output of errors in check mojo [#119](https://github.com/nbbrd/heylogs/issues/119)

## [0.5.0] - 2022-11-29

### Added

- Validate project version with Semantic Versioning specification in Maven plugin [#45](https://github.com/nbbrd/heylogs/issues/45)

### Changed

- Modify check goal in Maven plugin to raise error if changelog is missing on root project [#46](https://github.com/nbbrd/heylogs/issues/46)
- Change default phase of check goal to `VALIDATE` in Maven plugin [#47](https://github.com/nbbrd/heylogs/issues/47)

## [0.4.0] - 2022-10-20

### Added

- Add optional semantic versioning rule [#22](https://github.com/nbbrd/heylogs/issues/22)
- Add command to scan content of changelog [#26](https://github.com/nbbrd/heylogs/issues/26)
- Add missing descriptions in CLI [#29](https://github.com/nbbrd/heylogs/issues/29)

### Changed

- Simplify command parameters [#11](https://github.com/nbbrd/heylogs/issues/11)

## [0.3.2] - 2022-10-03

### Removed

- Remove limit-heading-depth rule [#23](https://github.com/nbbrd/heylogs/issues/23)

## [0.3.1] - 2022-09-28

### Changed

- Modify default ref parameter of extract mojo to `${project.version}` [#20](https://github.com/nbbrd/heylogs/issues/20)
- Modify extract mojo to fail if changelog is not found [#21](https://github.com/nbbrd/heylogs/issues/21)

## [0.3.0] - 2022-09-27

### Added

- Add rule extension point [#12](https://github.com/nbbrd/heylogs/issues/12)
- Add failure format extension point [#13](https://github.com/nbbrd/heylogs/issues/13)
- Add unreleased pattern to version filtering [#19](https://github.com/nbbrd/heylogs/issues/19)

### Changed

- Simplify properties naming of Maven plugin [#18](https://github.com/nbbrd/heylogs/issues/18)

## [0.2.0] - 2022-09-21

### Added

- Add Maven Plugin [#5](https://github.com/nbbrd/heylogs/issues/5)

## [0.1.0] - 2022-09-08

### Added

- Initial release

[Unreleased]: https://github.com/nbbrd/heylogs/compare/v0.7.1...HEAD
[0.7.1]: https://github.com/nbbrd/heylogs/compare/v0.7.0...v0.7.1
[0.7.0]: https://github.com/nbbrd/heylogs/compare/v0.6.0...v0.7.0
[0.6.0]: https://github.com/nbbrd/heylogs/compare/v0.5.0...v0.6.0
[0.5.0]: https://github.com/nbbrd/heylogs/compare/v0.4.0...v0.5.0
[0.4.0]: https://github.com/nbbrd/heylogs/compare/v0.3.2...v0.4.0
[0.3.2]: https://github.com/nbbrd/heylogs/compare/v0.3.1...v0.3.2
[0.3.1]: https://github.com/nbbrd/heylogs/compare/v0.3.0...v0.3.1
[0.3.0]: https://github.com/nbbrd/heylogs/compare/v0.2.0...v0.3.0
[0.2.0]: https://github.com/nbbrd/heylogs/compare/v0.1.0...v0.2.0
[0.1.0]: https://github.com/nbbrd/heylogs/releases/tag/v0.1.0
