# Steven Tardo
# UNO ID 2429860
# 20 June 2014
# CSCI 4990, Summer 2014
# Homework 1 Part 1
#
# This program will read an input file line by line with each line containing
# a last name, first name, 7 digit ID number, grade level, and three grades,
# each seperated by a space, then create an output file containing the line number,
# ID number, first name, last name, the three grades, their average, and the
# corresponding letter grade depending on grade level. To determine if the input
# is in the correct format on each line, a regular expression is used.

# The following regular expression checks each line to ensure it is in the correct format
studentExp = /[A-Z][a-z]+ [A-Z][a-z]+ [0-9]{7} [GJS] ([0-9]{1,2}|100) ([0-9]{1,2}|100) ([0-9]{1,2}|100)$/

count = 1 # Used for line count

# Open input file for reading and create output file for writing
input = File.open('input.txt', 'r')
output = File.open('output.txt', 'w')

# Read file line by line
while line = input.gets
  letterGrade = "A" # Set default letter grade
    match = studentExp.match(line) # Check line against regular expression
    lineArray = line.split(" ") # Split each token and place in an array
    
    # If line does not match regular expression, output error message
    if match == nil
      output.print count.to_s + ") " + lineArray[1] + " "
      output.puts lineArray[0] + ", Incorrect or Incomplete Data"
    
   # If line matches regular expression, average grades
    # and output corresponding information
    else
      grade1 = lineArray[4].to_f
      grade2 = lineArray[5].to_f
      grade3 = lineArray[6].to_f
      average = (grade1 + grade2 + grade3)/3.0
      average = average.round(2) # Round average grade to two decimal points
      
      # Check student's grade level to assign correct letter grade
      if lineArray[3] == "J"
        if average < 60
          letterGrade = "D"
        elsif average < 75
          letterGrade = "C"
        elsif average < 85
          letterGrade = "B"
        end
      end
      if lineArray[3] == "S"
        if average < 60
          letterGrade = "F"
        elsif average < 70
          letterGrade = "D"
        elsif average < 80
          letterGrade = "C"
        elsif average < 90
          letterGrade = "B"
        end
      end
      if lineArray[3] == "G"
        if average < 80
          letterGrade = "F"
        elsif average < 90
          letterGrade = "B"
        end
      end
      
      # Write data to output file
      output.print count.to_s + ") " + lineArray[2] + ", " + lineArray[1] + " "
      output.print lineArray[0] + " (" + lineArray[3] + "), " + lineArray[4] + " " + lineArray[5] + " "
      output.puts lineArray[6] + ", Average Grade: " + average.to_s + " (" + letterGrade + ")"
    end
    
    count = count + 1 # Update line count
  end

  # Close input and output files
  input.close
  output.close