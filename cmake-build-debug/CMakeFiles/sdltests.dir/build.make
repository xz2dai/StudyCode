# CMAKE generated file: DO NOT EDIT!
# Generated by "MinGW Makefiles" Generator, CMake Version 3.13

# Delete rule output on recipe failure.
.DELETE_ON_ERROR:


#=============================================================================
# Special targets provided by cmake.

# Disable implicit rules so canonical targets will work.
.SUFFIXES:


# Remove some rules from gmake that .SUFFIXES does not remove.
SUFFIXES =

.SUFFIXES: .hpux_make_needs_suffix_list


# Suppress display of executed commands.
$(VERBOSE).SILENT:


# A target that is always out of date.
cmake_force:

.PHONY : cmake_force

#=============================================================================
# Set environment variables for the build.

SHELL = cmd.exe

# The CMake executable.
CMAKE_COMMAND = "C:\Program Files\JetBrains\CLion 2018.3.3\bin\cmake\win\bin\cmake.exe"

# The command to remove a file.
RM = "C:\Program Files\JetBrains\CLion 2018.3.3\bin\cmake\win\bin\cmake.exe" -E remove -f

# Escaping for special characters.
EQUALS = =

# The top-level source directory on which CMake was run.
CMAKE_SOURCE_DIR = C:\Users\xz2dai\Documents\study

# The top-level build directory on which CMake was run.
CMAKE_BINARY_DIR = C:\Users\xz2dai\Documents\study\cmake-build-debug

# Include any dependencies generated for this target.
include CMakeFiles/sdltests.dir/depend.make

# Include the progress variables for this target.
include CMakeFiles/sdltests.dir/progress.make

# Include the compile flags for this target's objects.
include CMakeFiles/sdltests.dir/flags.make

CMakeFiles/sdltests.dir/sdltests.cpp.obj: CMakeFiles/sdltests.dir/flags.make
CMakeFiles/sdltests.dir/sdltests.cpp.obj: CMakeFiles/sdltests.dir/includes_CXX.rsp
CMakeFiles/sdltests.dir/sdltests.cpp.obj: ../sdltests.cpp
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green --progress-dir=C:\Users\xz2dai\Documents\study\cmake-build-debug\CMakeFiles --progress-num=$(CMAKE_PROGRESS_1) "Building CXX object CMakeFiles/sdltests.dir/sdltests.cpp.obj"
	C:\x86_64-7.2.0-posix-seh-rt_v5-rev1\mingw64\bin\g++.exe  $(CXX_DEFINES) $(CXX_INCLUDES) $(CXX_FLAGS) -o CMakeFiles\sdltests.dir\sdltests.cpp.obj -c C:\Users\xz2dai\Documents\study\sdltests.cpp

CMakeFiles/sdltests.dir/sdltests.cpp.i: cmake_force
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green "Preprocessing CXX source to CMakeFiles/sdltests.dir/sdltests.cpp.i"
	C:\x86_64-7.2.0-posix-seh-rt_v5-rev1\mingw64\bin\g++.exe $(CXX_DEFINES) $(CXX_INCLUDES) $(CXX_FLAGS) -E C:\Users\xz2dai\Documents\study\sdltests.cpp > CMakeFiles\sdltests.dir\sdltests.cpp.i

CMakeFiles/sdltests.dir/sdltests.cpp.s: cmake_force
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green "Compiling CXX source to assembly CMakeFiles/sdltests.dir/sdltests.cpp.s"
	C:\x86_64-7.2.0-posix-seh-rt_v5-rev1\mingw64\bin\g++.exe $(CXX_DEFINES) $(CXX_INCLUDES) $(CXX_FLAGS) -S C:\Users\xz2dai\Documents\study\sdltests.cpp -o CMakeFiles\sdltests.dir\sdltests.cpp.s

# Object files for target sdltests
sdltests_OBJECTS = \
"CMakeFiles/sdltests.dir/sdltests.cpp.obj"

# External object files for target sdltests
sdltests_EXTERNAL_OBJECTS =

sdltests.exe: CMakeFiles/sdltests.dir/sdltests.cpp.obj
sdltests.exe: CMakeFiles/sdltests.dir/build.make
sdltests.exe: CMakeFiles/sdltests.dir/linklibs.rsp
sdltests.exe: CMakeFiles/sdltests.dir/objects1.rsp
sdltests.exe: CMakeFiles/sdltests.dir/link.txt
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green --bold --progress-dir=C:\Users\xz2dai\Documents\study\cmake-build-debug\CMakeFiles --progress-num=$(CMAKE_PROGRESS_2) "Linking CXX executable sdltests.exe"
	$(CMAKE_COMMAND) -E cmake_link_script CMakeFiles\sdltests.dir\link.txt --verbose=$(VERBOSE)

# Rule to build all files generated by this target.
CMakeFiles/sdltests.dir/build: sdltests.exe

.PHONY : CMakeFiles/sdltests.dir/build

CMakeFiles/sdltests.dir/clean:
	$(CMAKE_COMMAND) -P CMakeFiles\sdltests.dir\cmake_clean.cmake
.PHONY : CMakeFiles/sdltests.dir/clean

CMakeFiles/sdltests.dir/depend:
	$(CMAKE_COMMAND) -E cmake_depends "MinGW Makefiles" C:\Users\xz2dai\Documents\study C:\Users\xz2dai\Documents\study C:\Users\xz2dai\Documents\study\cmake-build-debug C:\Users\xz2dai\Documents\study\cmake-build-debug C:\Users\xz2dai\Documents\study\cmake-build-debug\CMakeFiles\sdltests.dir\DependInfo.cmake --color=$(COLOR)
.PHONY : CMakeFiles/sdltests.dir/depend

