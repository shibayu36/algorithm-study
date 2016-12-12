#!/usr/bin/env perl
use strict;
use warnings;
use utf8;


sub binary_search {
    my ($data, $number) = @_;

    my $left = 0;
    my $right = scalar(@$data) - 1;
    my $result = -1;

    while (1) {
        last if ($right < $left);

        my $middle = int(($right + $left) / 2);

        if ($data->[$middle] == $number) {
            $result = $middle;
            last;
        }
        elsif ($number > $data->[$middle]) {
            $left = $middle + 1;
        }
        elsif ($number < $data->[$middle]) {
            $right = $middle - 1;
        }
    }

    return $result;
}

my $data = [ qw(3 5 8 9 15 28 46) ];
warn binary_search($data, 5);
warn binary_search($data, 28);
warn binary_search($data, 0);
