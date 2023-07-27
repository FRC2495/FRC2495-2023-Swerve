# Swerve sandbox

See [the online changelog](https://github.com/FRC2495/MAXSwerve/blob/main/CHANGELOG.md) for information about updates since this project was created.

## Description

A sandbox project for an FRC swerve drivetrain that uses MK4i Swerve Modules, derived from the REV MAXSwerve template (https://github.com/REVrobotics/MAXSwerve-Java-Template)

Note that this is meant to be used with a drivetrain composed of four MK4i Swerve Modules, each configured with two SPARKS MAX, a NEO as the driving motor, a NEO as the turning motor, and a Thrifty encoder as the absolute turning encoder.

## Prerequisites

* SPARK MAX Firmware v1.6.2 - Adds features that are required for swerve
* REVLib v2023.1.2 - Includes APIs for the new firmware features

## Configuration

It is possible that this project will not work for your robot right out of the box. Various things like the CAN IDs, PIDF gains, chassis configuration, etc. must be determined for your own robot!

These values can be adjusted in the `Constants.java` file.
