package main

import (
	"fmt"
	"io/ioutil"
)

func react(content []byte, byteToExclude byte) int {
	var contentLen = len(content)
	var indexLen = 0
	var indexArr = make([]int, contentLen)

	for contentIndex := 0; contentIndex < contentLen; contentIndex++ {
		if content[contentIndex] != byteToExclude && content[contentIndex] != byteToExclude+32 {
			indexArr[indexLen] = contentIndex
			indexLen++
		}
	}

	var recentReaction = true
	for recentReaction {
		recentReaction = false
		for index := 0; index < indexLen-1; index++ {
			var diff = (int8)(content[indexArr[index]] - content[indexArr[index+1]])
			if diff == 32 || diff == -32 {
				recentReaction = true;
				for subIndex := index; subIndex < indexLen-2; subIndex++ {
					indexArr[subIndex] = indexArr[subIndex+2]
				}
				indexLen = indexLen - 2
				index = index - 1
			}
		}
	}

	return indexLen
}

func main() {
	var content, err = ioutil.ReadFile("day5_input.txt")
	if err != nil {
		fmt.Println("Error reading input file", err)
		return
	}

	fmt.Println("Part 1: ", react(content, 0))
	// fmt.Println("Part 1: ", react(content, 'A'))

	var index byte
	for index = 'A'; index < 'Z'; index++ {
		fmt.Println("Part 2: ", react(content, index))
	}
}
