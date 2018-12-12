package main

import (
	"fmt"
	"math"
	"os"
)

type Point struct {
	x    int
	y    int
	velX int
	velY int
}

var points = make([]Point, 0)

func streamInputForDay10(line string) {
	var newPoint Point
	var _, err = fmt.Sscanf(line, "position=<%d,  %d> velocity=<%d, %d>", &newPoint.x, &newPoint.y, &newPoint.velX, &newPoint.velY)
	if err != nil {
		fmt.Println("Error parsing input line ", err)
		return
	}
	points = append(points, newPoint)
}

func day10Part1() {
	fmt.Println(points)

	for moveIndex := 0; moveIndex < 30000; moveIndex++ {
		var maxX = math.MaxInt32
		var maxY = math.MaxInt32

		for pointIndex := 0; pointIndex < len(points); pointIndex++ {
			points[pointIndex].x += points[pointIndex].velX
			points[pointIndex].y += points[pointIndex].velY
			maxX = Max(maxX, Abs(points[pointIndex].x))
			maxY = Max(maxY, Abs(points[pointIndex].y))
		}

		if maxX < 300 {
			break
		}
	}
	fmt.Println(points)
}

func main() {
	var inputStr = os.Args[1]
	err := StreamFileAsStringLines(inputStr, streamInputForDay10);
	if err != nil {
		fmt.Println("Error reading input file: "+inputStr, err)
	}

	day10Part1()
}
