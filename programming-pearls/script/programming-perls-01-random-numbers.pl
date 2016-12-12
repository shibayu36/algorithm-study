#!/usr/bin/env perl
use strict;
use warnings;
use utf8;

use feature qw(say);

my $max_num = 1000000;
my $pickup_num = 100000;

my $numbers = [1..$max_num];

use Benchmark qw(cmpthese);
use List::Util qw(shuffle);

cmpthese(10, {
    shuffle => sub {
        my $shuffled = [ shuffle @$numbers ];
        my $picked   = [ splice(@$shuffled, 0, $pickup_num) ];
        say 'shuffle';
        debug($picked);
        return $picked;
    },
    # random_pickup => sub {
    #     my $cloned = [ @$numbers ];
    #     my $picked = [];
    #     my $data_length = scalar(@$cloned);
    #     for my $i (1..$pickup_num) {
    #         my ($num) = splice @$cloned, int(rand($data_length)), 1;
    #         push @$picked, $num;
    #         $data_length--;
    #     }

    #     say 'random';
    #     debug($picked);

    #     return $picked;
    # },
    swap_pickup => sub {
        # randomピックアップを配列の前の方と後ろの方でやるのが面白い
        my $cloned = [ @$numbers ];
        for my $i (0 .. $pickup_num-1) {
            my $random = $i + int(rand($max_num - $i));
            my $tmp = $cloned->[$i];
            $cloned->[$i] = $cloned->[$random];
            $cloned->[$random] = $tmp;
        }
        my $picked = [ splice(@$cloned, 0, $pickup_num) ];
        say 'swap';
        debug($picked);
        return $picked;
    },
});

sub debug {
    my ($array) = @_;
    say 'length: ', scalar @$array;
    for (0..2) {
        say $_, ': ', $array->[$_];
    }
}
