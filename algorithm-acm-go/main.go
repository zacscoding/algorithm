package main

import (
	"fmt"
	"os"
	"path/filepath"
	"strconv"
	"text/template"
)

const (
	HOME = iota
	COMP
)

var source = `// https://www.acmicpc.net/problem/{{.problem}}
package main

func main() {
}
`

// main create a source file for solving problem.
func main() {
	createSourceFile()
}

// createSourceFile create a default main.go source file
func createSourceFile() {
	p := 11047
	sourceDir := getSourceDir()
	pDir := filepath.Join(sourceDir, "p"+strconv.Itoa(p))
	// create pXXX dir
	_, err := os.Stat(pDir)
	if err != nil {
		if !os.IsNotExist(err) {
			fmt.Println(err)
			os.Exit(1)
		}
		err = os.Mkdir(pDir, 0700)
		if err != nil {
			fmt.Println(err)
			os.Exit(1)
		}
		fmt.Println("Success to directory:", pDir)
	}

	// create pXXX/main.go source file
	sFile := filepath.Join(pDir, "main.go")
	_, err = os.Stat(sFile)
	if err != nil {
		if !os.IsNotExist(err) {
			fmt.Println(err)
			os.Exit(1)
		}
	}
	fi, err := os.Create(sFile)
	if err != nil {
		fmt.Println(err)
		os.Exit(1)
	}
	defer fi.Close()
	tmpl, err := template.New("source").Parse(source)
	if err != nil {
		fmt.Println(err)
		os.Exit(1)
	}

	m := make(map[string]int)
	m["problem"] = p
	err = tmpl.Execute(fi, m)
	if err != nil {
		fmt.Println(err)
		os.Exit(1)
	}
}

// getSourceDir returns source directory depends on working location.
func getSourceDir() string {
	//work := HOME
	work := COMP
	if work == HOME {
		return "C:\\git\\zaccoding\\algorithm\\algorithm-acm-go"
	} else if work == COMP {
		return "/home/zaccoding/git/zaccoding/algorithm/algorithm-acm-go"
	}
	return ""
}
