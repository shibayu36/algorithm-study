#!/usr/bin/env perl
use strict;
use warnings;
use utf8;

# 実装失敗した

sub jaggling {
    my ($data, $rotation) = @_;

    my $rotated = [ @$data ];
    my $n = scalar(@$rotated);

    my $to = 0;
    my $tmp = $data->[0];

    for (1..$n) {
        my $from = ($to + $rotation) % $n;

        if ($from == 0) {
            $rotated->[$to] = $tmp;
            $tmp = $rotated->[0];
            $from = 1;
        }
        else {
            $rotated->[$to] = $rotated->[$from];
        }

        $to = $from;
    }

    return $rotated;
}

my $data = [qw(a b c d e f g h)];
use Data::Printer { show_unicode => 1, use_prototypes => 0, colored => 0, class => { show_methods => 0 } }; p(jaggling($data, 4));
