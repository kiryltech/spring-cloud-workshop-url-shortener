#!/bin/bash

echo "digraph nodes {"

for log_file in `find target/logs -type f`
do
    filename_without_ext=`basename $log_file | sed -e s/\.log\.txt//`
    ip_addr=${filename_without_ext%.*}
    service_name=${filename_without_ext##*.}
    echo "\"$ip_addr\" [label=\"$service_name\n$ip_addr\"]"

    cat $log_file | \
        grep -o "Before request.*" | \
        sed -e 's/^.*client=/ /g' -e 's/]$//g' | \
        sort | uniq -c | while read count source_addr; do
            echo "\"$source_addr\" -> \"$ip_addr\" [label=\"$count\"]"
        done
done

echo "}"