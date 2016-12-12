#!/usr/bin/env perl
use strict;
use warnings;
use utf8;

sub compute_prefix_function {
    my ($string) = @_;

    my $p = [ split //, $string ];

    my $s = [];
    $s->[0] = 0;

    my $border = 0;

    for my $i (1..scalar(@$p)-1) {
        my $char = $p->[$i];

        while (($border > 0) && ($p->[$i] ne $p->[$border])) {
            $border = $s->[$border - 1];
        }

        if ($p->[$i] eq $p->[$border]) {
            $border = $border + 1;
        }
        else {
            $border = 0;
        }

        $s->[$i] = $border;
    }

    return $s;
}

sub compare {
    my ($pattern, $string) = @_;

    my $concat = $pattern . '$' . $string;

    my $prefix_function = compute_prefix_function($concat);

    my $pattern_length = length($pattern);
    my $concat_length = length($concat);

    my $result = [];
    for my $index ($pattern_length..$concat_length - 1) {
        if ($prefix_function->[$index] == $pattern_length) {
            push @$result, $index - $pattern_length - $pattern_length;
        }
    }

    return $result;
}

my $result = compare('ATAT', 'GATATATGCATATACTT');
use Data::Printer { show_unicode => 1, use_prototypes => 0, colored => 0, class => { show_methods => 0 } }; p($result);
