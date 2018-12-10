package main

import (
	"bufio"
	"fmt"
	"io"
	"math"
	"os"
)

func ReadFileToIntArray(fileName string, array []int) (int, error) {
	fileDesc, err := os.Open(fileName)
	if err != nil {
		return 0, err
	}
	defer fileDesc.Close()

	var numbersLen = 0
	var number int
	for {
		_, err := fmt.Fscanf(fileDesc, "%d\n", &number)
		if err != nil {
			if err == io.EOF {
				return numbersLen, nil
			}
			fmt.Println(err)
			return 0, err
		}
		array[numbersLen] = number
		numbersLen++
	}
}

func ReadFileToStringArray(fileName string, array []string) (int, error) {
	fileDesc, err := os.Open(fileName)
	if err != nil {
		return 0, err
	}
	defer fileDesc.Close()

	var linesLen = 0
	var scanner = bufio.NewScanner(fileDesc)
	for scanner.Scan() {
		array[linesLen] = scanner.Text()
		linesLen++
	}

	err = scanner.Err()
	if err != nil {
		return 0, err
	}

	return linesLen, nil
}

type stringLineHandler func(string)

func StreamFileAsStringLines(fileName string, handler stringLineHandler) error {
	fileDesc, err := os.Open(fileName)
	if err != nil {
		return err
	}
	defer fileDesc.Close()

	var scanner = bufio.NewScanner(fileDesc)
	for scanner.Scan() {
		handler(scanner.Text())
	}

	err = scanner.Err()
	if err != nil {
		return err
	}

	return nil
}

func ScanString(content string, format string, a ...interface{}) {
	_, err := fmt.Sscanf(content, format, a...)
	if err != nil {
		fmt.Println("Failed to parse string content: "+content, err)
		return
	}
}

func Max(v1 int, v2 int) int {
	if v1 < v2 {
		return v2
	}
	return v1
}

func Min(v1 int, v2 int) int {
	if v1 < v2 {
		return v1
	}
	return v2
}

func MaxValue(array []int) int {
	var maxValue = math.MinInt32
	for index := 0; index < len(array); index++ {
		if array[index] > maxValue {
			maxValue = array[index]
		}
	}

	return maxValue
}

func Abs(value int) int {
	if value < 0 {
		return -value
	}
	return value
}
