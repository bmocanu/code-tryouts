package aoc_2018

import (
	"fmt"
	"math"
	"os"
)

const X = 0
const Y = 1

var coords = [100][2]int{}
var coordsLen int
var maxX int
var maxY int

var fieldSizes []int

func handleStringLineForDay6(line string) {
	var x, y int
	ScanString(line, "%d, %d\n", &x, &y)

	coords[coordsLen][X] = x
	coords[coordsLen][Y] = y
	coordsLen++

	maxX = Max(x, maxX)
	maxY = Max(y, maxY)
}

func day6part1() int {
	var fieldWidth = maxX + 2
	var fieldHeight = maxY + 2
	var fieldSizes = make([]int, coordsLen)

	for y := 0; y < fieldHeight; y++ {
		for x := 0; x < fieldWidth; x++ {
			var currentProximity = countProximity(x, y)
			if currentProximity < 0 || fieldSizes[currentProximity] < 0 {
				continue
			}
			if x == 0 || y == 0 || x == fieldWidth-1 || y == fieldHeight-1 {
				fieldSizes[currentProximity] = -1
			} else {
				fieldSizes[currentProximity]++
			}
		}
	}

	return MaxValue(fieldSizes[0:])
}

func day6part2() int {
	var fieldWidth = maxX + 2
	var fieldHeight = maxY + 2
	var result int

	for y := 0; y < fieldHeight; y++ {
		for x := 0; x < fieldWidth; x++ {
			var currentDistSum = countDistSum(x, y)
			if currentDistSum < 10000 {
				result++
			}
		}
	}

	return result
}

func taxicabDistance(x1 int, y1 int, x2 int, y2 int) int {
	return Abs(x1-x2) + Abs(y1-y2)
}

// Counts the coordinate that is closest to the given x and y and returns the index of that coordinate, or -1 if there
// is a tie
func countProximity(x int, y int) int {
	var minCoordIndex = 0
	var minCoordApp = 0
	var minCoordDistance = math.MaxInt32
	for index := 0; index < coordsLen; index++ {
		var currentDist = taxicabDistance(x, y, coords[index][X], coords[index][Y])
		if currentDist < minCoordDistance {
			minCoordDistance = currentDist
			minCoordIndex = index
			minCoordApp = 1
		} else if currentDist == minCoordDistance {
			minCoordApp++
		}
	}

	if minCoordApp > 1 {
		return -1
	}

	return minCoordIndex
}

func countDistSum(x int, y int) int {
	var sum int
	for index := 0; index < coordsLen; index++ {
		var currentDist = taxicabDistance(x, y, coords[index][X], coords[index][Y])
		sum += currentDist
	}

	return sum
}

func main_day6() {
	var inputStr = os.Args[1]
	err := StreamFileAsStringLines(inputStr, handleStringLineForDay6);
	if err != nil {
		fmt.Println("Error reading input file: "+inputStr, err)
	}

	fmt.Println("Part 1: ", day6part1())
	fmt.Println("Part 2: ", day6part2())
}
