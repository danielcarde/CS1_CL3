# CL3: Music Playlist Library

A console-based music library and playlist manager that loads songs from a text file and lets a user build and manage a playlist.

## Highlights
Reads song data from song_library.txt.
Models songs, playlists, a library, and a user with separate Java classes.
Supports adding songs from the library to a playlist.
Provides a console menu for interacting with the playlist.
Demonstrates a larger multi-file Java project.

## Overview
This comprehensive lab builds a small music library application. The program loads song records from a text file, stores them in a Library object, and lets the user work with a Playlist object through a console menu.
The assignment demonstrates how multiple classes can collaborate to represent a larger application domain.

## Why This Project
This project is useful because it moves beyond isolated exercises into object-oriented application structure. It shows how Java classes can divide responsibilities while still working together through a menu-driven user experience.

## Usage
Compile: Compile all Java files in the folder using javac *.java.
Run: Execute the program with java Solution.
Keep song_library.txt in the same folder so the library can load its song data.

## Installation
Ensure you have the Java Development Kit (JDK) installed on your system.
Open a terminal in the lab folder before compiling so the program can find any required local text files.

## Architecture
File Structure: The project consists of Solution.java, Song.java, Playlist.java, Library.java, User.java, and song_library.txt.
Components: Solution.java is the driver and menu controller. Song.java models each song. Playlist.java manages selected songs. Library.java stores available songs. User.java stores user-specific playlist information.

## Future Improvements
Add persistent saving for user playlists.
Allow searching and filtering by artist or genre.
Add stronger input validation for menu choices and song names.
