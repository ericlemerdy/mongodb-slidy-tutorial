#!sh
watch -n 10 'pandoc -s --webtex -i -t slidy tutorial.txt -o tutorial.html'
