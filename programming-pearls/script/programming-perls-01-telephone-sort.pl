#!/usr/bin/env perl
use strict;
use warnings;
use utf8;

my $data = [qw(
    123
    567
    1382
    2
    57
    83
)];

my $bit_list = [];

for my $num (@$data) {
    $bit_list->[$num] = 1;
}

my $result = [];
for my $index (0..scalar(@$bit_list)) {
    push @$result, $index if $bit_list->[$index];
}

use Data::Printer { show_unicode => 1, use_prototypes => 0, colored => 0, class => { show_methods => 0 } }; p($result);
