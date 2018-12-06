package main

import (
	"bufio"
	"fmt"
	"io"
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
